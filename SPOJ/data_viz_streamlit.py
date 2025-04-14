import streamlit as st
import pandas as pd
from groq import Groq
import os
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np
from datetime import datetime
import io
import openpyxl
import plotly.express as px
import plotly.graph_objects as go
from plotly.subplots import make_subplots

# Set matplotlib to use a non-interactive backend
plt.switch_backend('Agg')

# Configure Streamlit page
st.set_page_config(
    page_title="Data Chat Assistant",
    page_icon="📊",
    layout="wide"
)

# Load environment variables
if os.path.exists(".env"):
    from dotenv import load_dotenv
    load_dotenv()
    default_api_key = os.getenv("GROQ_API_KEY", "")
else:
    default_api_key = ""

# Initialize session states
if 'messages' not in st.session_state:
    st.session_state.messages = []
if 'data' not in st.session_state:
    st.session_state.data = None
if 'file_name' not in st.session_state:
    st.session_state.file_name = None

# Function to display and download Plotly charts
def display_and_download_plotly(fig, plot_title="Interactive Chart"):
    """Display a Plotly figure in Streamlit and provide a download option"""
    # Display the interactive plot
    st.plotly_chart(fig, use_container_width=True)
    

    buffer = io.StringIO()
    fig.write_html(buffer, include_plotlyjs='cdn', full_html=True, config={'displayModeBar': True, 'displaylogo': False})
    html_bytes = buffer.getvalue().encode()
    
    # Generate filename with timestamp
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    filename = f"{plot_title.lower().replace(' ', '_')}_{timestamp}.html"
    
    # Create download button with unique key
    unique_key = f"download_plotly_{timestamp}_{np.random.randint(0, 10000)}"
    
    st.download_button(
        label=f"Download Interactive {plot_title}",
        data=html_bytes,
        file_name=filename,
        mime="text/html",
        key=unique_key
    )

# Function to display and download matplotlib plots
def display_and_download_plot(fig, plot_title="Chart", use_container_width=True):
    """Display a matplotlib figure and provide a download button"""
    # Display the plot in Streamlit
    st.pyplot(fig, use_container_width=use_container_width)
    
    # Create a download button for the plot
    buf = io.BytesIO()
    fig.savefig(buf, format='png', bbox_inches='tight', dpi=300)
    buf.seek(0)
    
    # Generate a unique filename with timestamp
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    filename = f"{plot_title.lower().replace(' ', '_')}_{timestamp}.png"
    
    # Create download button with a unique key
    unique_key = f"download_{timestamp}_{np.random.randint(0, 10000)}"
    
    st.download_button(
        label=f"Download {plot_title}",
        data=buf,
        file_name=filename,
        mime="image/png",
        key=unique_key
    )

# Function to convert dataframe to CSV for download
def convert_df_to_csv(df):
    """Convert dataframe to CSV for download"""
    return df.to_csv(index=False).encode('utf-8')

# Function to load and optimize data
def load_data(file):
    """Load CSV or Excel data and optimize data types"""
    try:
        file_name = file.name.lower()
        if file_name.endswith('.csv'):
            df = pd.read_csv(file)
        elif file_name.endswith('.xlsx') or file_name.endswith('.xls'):
            df = pd.read_excel(file, engine='openpyxl')
        else:
            return None, "Unsupported file format. Please upload a CSV or Excel file."
            
        # Optimize data types
        for col in df.select_dtypes(['float64']).columns:
            df[col] = pd.to_numeric(df[col], downcast='float')
        for col in df.select_dtypes(['int64']).columns:
            df[col] = pd.to_numeric(df[col], downcast='integer')
        
        # Basic data cleaning - remove duplicate rows
        initial_rows = len(df)
        df = df.drop_duplicates()
        if len(df) < initial_rows:
            st.info(f"Removed {initial_rows - len(df)} duplicate rows.")
            
        return df, None
    except Exception as e:
        return None, f"Error loading file: {str(e)}"

# Function to create visualizations based on query
def create_visualization(df, query):
    """Create a visualization based on the user's query"""
    query = query.lower()
    
    # Detect chart type and columns from query
    columns = [col for col in df.columns if col.lower() in query]
    if not columns:
        return None, "No columns from your data were found in the query."
    
    try:
        # Determine chart type from query keywords
        if any(word in query for word in ['bar', 'count']):
            if len(columns) == 1:
                # Simple bar chart
                column = columns[0]
                counts = df[column].value_counts().nlargest(15)
                
                fig = px.bar(
                    x=counts.index, 
                    y=counts.values,
                    title=f"Count of {column} (Top 15)",
                    labels={'x': column, 'y': 'Count'}
                )
                return fig, "bar"
                
        elif any(word in query for word in ['pie', 'distribution']):
            if len(columns) == 1:
                # Pie chart
                column = columns[0]
                counts = df[column].value_counts().nlargest(10)
                
                fig = px.pie(
                    names=counts.index, 
                    values=counts.values,
                    title=f"Distribution of {column} (Top 10)"
                )
                return fig, "pie"
                
        elif any(word in query for word in ['scatter', 'relationship', 'correlation']):
            if len(columns) >= 2:
                # Scatter plot
                x_col, y_col = columns[0], columns[1]
                
                # Optional color column
                color_col = None
                if len(columns) > 2 and any(word in query for word in ['color', 'group', 'by']):
                    color_col = columns[2]
                
                fig = px.scatter(
                    df,
                    x=x_col,
                    y=y_col,
                    color=color_col,
                    title=f"{y_col} vs {x_col}" + (f" colored by {color_col}" if color_col else "")
                )
                return fig, "scatter"
                
        elif any(word in query for word in ['histogram', 'distribution']):
            if len(columns) == 1:
                # Histogram
                column = columns[0]
                if pd.api.types.is_numeric_dtype(df[column]):
                    fig = px.histogram(
                        df,
                        x=column,
                        title=f"Distribution of {column}",
                        nbins=20
                    )
                    return fig, "histogram"
                    
        elif any(word in query for word in ['box', 'boxplot', 'outlier']):
            if len(columns) == 1:
                # Box plot
                column = columns[0]
                if pd.api.types.is_numeric_dtype(df[column]):
                    fig = px.box(
                        df,
                        y=column,
                        title=f"Box Plot of {column}"
                    )
                    return fig, "box"
                    
        elif any(word in query for word in ['line', 'trend', 'time']):
            if len(columns) == 1:
                # Line chart
                column = columns[0]
                if pd.api.types.is_numeric_dtype(df[column]):
                    fig = px.line(
                        df,
                        y=column,
                        title=f"Line Plot of {column}"
                    )
                    return fig, "line"
        
        elif any(word in query for word in ['correlation', 'heatmap']):
            # Correlation heatmap
            numeric_cols = df.select_dtypes(include=['number']).columns
            if len(numeric_cols) >= 2:
                corr_matrix = df[numeric_cols].corr().round(2)
                
                fig = px.imshow(
                    corr_matrix,
                    text_auto=True,
                    color_continuous_scale='RdBu_r',
                    title="Correlation Matrix"
                )
                return fig, "heatmap"
                
        # If no specific chart type is detected but columns are valid
        if len(columns) == 1:
            column = columns[0]
            if pd.api.types.is_numeric_dtype(df[column]):
                # Default to histogram for numeric columns
                fig = px.histogram(
                    df,
                    x=column,
                    title=f"Distribution of {column}",
                    nbins=20
                )
                return fig, "histogram"
            else:
                # Default to bar chart for categorical columns
                counts = df[column].value_counts().nlargest(15)
                fig = px.bar(
                    x=counts.index, 
                    y=counts.values,
                    title=f"Count of {column} (Top 15)",
                    labels={'x': column, 'y': 'Count'}
                )
                return fig, "bar"
                
        return None, "Could not determine an appropriate visualization from your query."
        
    except Exception as e:
        return None, f"Error creating visualization: {str(e)}"

# Function to generate a summary of the data
def generate_data_summary(df):
    """Generate a quick summary of the dataset"""
    summary = []
    
    # Basic info
    summary.append(f"- Dataset has {df.shape[0]} rows and {df.shape[1]} columns")
    
    # Column types
    num_cols = len(df.select_dtypes(include=['number']).columns)
    cat_cols = len(df.select_dtypes(exclude=['number']).columns)
    summary.append(f"- Contains {num_cols} numeric columns and {cat_cols} categorical/text columns")
    
    # Missing values
    missing = df.isnull().sum()
    cols_with_missing = missing[missing > 0]
    if len(cols_with_missing) > 0:
        summary.append(f"- {len(cols_with_missing)} columns have missing values")
        top_missing = cols_with_missing.nlargest(3)
        missing_str = ", ".join([f"{col}: {count} ({count/len(df)*100:.1f}%)" for col, count in top_missing.items()])
        summary.append(f"- Top columns with missing values: {missing_str}")
    else:
        summary.append("- No missing values detected")
        
    # For numeric columns
    numeric_cols = df.select_dtypes(include=['number']).columns
    if len(numeric_cols) > 0:
        numeric_summary = df[numeric_cols].describe().T
        min_val_col = numeric_summary['min'].idxmin()
        max_val_col = numeric_summary['max'].idxmax()
        summary.append(f"- Column with lowest minimum: {min_val_col} ({numeric_summary.loc[min_val_col, 'min']:.2f})")
        summary.append(f"- Column with highest maximum: {max_val_col} ({numeric_summary.loc[max_val_col, 'max']:.2f})")
        
    # For categorical columns
    cat_cols = df.select_dtypes(exclude=['number']).columns
    if len(cat_cols) > 0:
        max_unique = 0
        max_unique_col = ""
        for col in cat_cols:
            unique_count = df[col].nunique()
            if unique_count > max_unique:
                max_unique = unique_count
                max_unique_col = col
                
        if max_unique_col:
            summary.append(f"- Column with most unique values: {max_unique_col} ({max_unique} unique values)")
    
    return summary

# Main UI
st.title("Data Chat Assistant")

# Sidebar for settings
with st.sidebar:
    st.header("Settings")
    
    # API Key section
    with st.expander("API Settings", expanded=False):
        groq_api_key = st.text_input(
            "Groq API Key", 
            value=default_api_key,
            type="password", 
            help="Get your Groq API key from https://console.groq.com"
        )
        
        model_option = st.selectbox(
            "Model",
            ["llama-3.3-70b-versatile", "llama-3.1-70b-versatile", "mixtral-8x7b-32768", "gemma-2-27b-it"],
            index=0,
            help="Select the LLM model to use for analysis"
        )
    
    # File uploader
    st.subheader("Upload Data")
    uploaded_file = st.file_uploader("Choose a file", type=["csv", "xlsx", "xls"])
    
    if uploaded_file is not None:
        st.success(f"File uploaded: {uploaded_file.name}")
        
        # Load data
        data, error = load_data(uploaded_file)
        if error:
            st.error(error)
        else:
            # Store in session state
            st.session_state.data = data
            st.session_state.file_name = uploaded_file.name
            
            # Show data info
            st.write(f"Rows: {data.shape[0]}, Columns: {data.shape[1]}")
            
            # Download options
            st.download_button(
                label="Download as CSV",
                data=convert_df_to_csv(data),
                file_name=f"processed_{uploaded_file.name.split('.')[0]}.csv",
                mime="text/csv"
            )

# Main area
if st.session_state.data is not None:
    # Data preview in expander
    with st.expander("Data Preview", expanded=False):
        st.dataframe(st.session_state.data.head(10), use_container_width=True)
        
        # Column info
        st.subheader("Column Information")
        col_info = pd.DataFrame({
            'Column': st.session_state.data.columns,
            'Type': st.session_state.data.dtypes.astype(str),
            'Missing': st.session_state.data.isnull().sum(),
            'Unique Values': [st.session_state.data[col].nunique() for col in st.session_state.data.columns]
        })
        st.dataframe(col_info, use_container_width=True)
    
    # Chat interface
    st.subheader("Chat with Your Data")
    st.write("Ask questions about your data or request visualizations. The assistant will analyze and visualize your data on demand.")
    
    # Display chat messages
    for message in st.session_state.messages:
        with st.chat_message(message["role"]):
            st.markdown(message["content"])
            
            # Display visualization if present
            if "visualization" in message:
                viz_info = message["visualization"]
                if viz_info["type"] == "plotly":
                    display_and_download_plotly(viz_info["figure"], viz_info["title"])
                elif viz_info["type"] == "matplotlib":
                    display_and_download_plot(viz_info["figure"], viz_info["title"])
            
            # Display dataframe if present
            if "dataframe" in message:
                st.dataframe(message["dataframe"], use_container_width=True)
                
                # Add download button for the dataframe
                st.download_button(
                    label="Download this table",
                    data=convert_df_to_csv(message["dataframe"]),
                    file_name=f"result_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv",
                    mime="text/csv"
                )
    
    # Chat input
    if prompt := st.chat_input("Ask about your data"):
        # Add user message to chat
        st.session_state.messages.append({"role": "user", "content": prompt})
        
        # Display user message
        with st.chat_message("user"):
            st.markdown(prompt)
        
        # Generate response
        with st.chat_message("assistant"):
            with st.spinner("Analyzing your data..."):
                try:
                    # Check for direct visualization requests
                    if any(keyword in prompt.lower() for keyword in 
                           ['show', 'plot', 'visualize', 'graph', 'chart', 'histogram', 
                            'bar chart', 'scatter', 'correlation', 'distribution']):
                        
                        # Try to create visualization directly
                        fig, chart_type = create_visualization(st.session_state.data, prompt)
                        
                        if fig is not None:
                            # Success message
                            st.write(f"Here's the {chart_type} chart you requested:")
                            
                            # Display and add to message history
                            display_and_download_plotly(fig, f"{chart_type.title()} Chart")
                            
                            # Add to message history
                            st.session_state.messages.append({
                                "role": "assistant",
                                "content": f"Here's the {chart_type} chart you requested:",
                                "visualization": {
                                    "type": "plotly",
                                    "figure": fig,
                                    "title": f"{chart_type.title()} Chart"
                                }
                            })
                        else:
                            # If direct visualization failed, use Groq
                            use_groq = True
                    else:
                        # Not a visualization request, use Groq
                        use_groq = True
                        
                    # Use Groq for non-visualization requests or failed visualizations
                    if 'use_groq' in locals() and use_groq:
                        if not groq_api_key:
                            st.error("Please enter your Groq API key in the sidebar to analyze the data.")
                            st.session_state.messages.append({
                                "role": "assistant",
                                "content": "I need a Groq API key to answer that question. Please add your API key in the sidebar settings."
                            })
                        else:
                            # Initialize Groq client
                            client = Groq(api_key=groq_api_key)
                            
                            # Prepare context about the data
                            data_info = f"Data columns: {', '.join(st.session_state.data.columns.tolist())}\n"
                            data_info += f"Data types: {dict(zip(st.session_state.data.columns, st.session_state.data.dtypes.astype(str).tolist()))}\n"
                            data_info += f"Sample data:\n{st.session_state.data.head(5).to_string()}\n"
                            data_info += f"Summary statistics:\n{st.session_state.data.describe().to_string()}"
                            
                            # Get previous context from conversation history
                            previous_context = ""
                            if len(st.session_state.messages) > 1:
                                context_messages = st.session_state.messages[-min(4, len(st.session_state.messages)):]
                                for msg in context_messages:
                                    previous_context += f"{msg['role']}: {msg['content']}\n"
                            
                            # Create the full prompt with context
                            full_prompt = f"""You are a data analysis assistant. Analyze the following data and answer the question.
                            
                            Data Information:
                            {data_info}
                            
                            Previous conversation:
                            {previous_context}
                            
                            User Question: {prompt}
                            
                            If the question asks for a visualization, respond with Python code that creates a visualization. 
                            Use the following template for visualization code:
                            ```python
                            import plotly.express as px
                            # Create visualization here
                            fig = px.<chart_type>(...)
                            ```
                            
                            Make the plots visually appealing and always create a plotly figure named 'fig'.
                            If the user is asking for summary statistics, calculations, or subsets of the data,
                            format your response with markdown tables and provide concise explanations.
                            """
                            
                            # Get response from Groq
                            response = client.chat.completions.create(
                                messages=[{"role": "user", "content": full_prompt}],
                                model=model_option,
                                temperature=0.2,
                                max_tokens=2048
                            )
                            
                            answer = response.choices[0].message.content
                            
                            # Check if response contains code
                            if "```python" in answer:
                                # Extract text before code
                                before_code = answer[:answer.find("```python")]
                                if before_code.strip():
                                    st.markdown(before_code)
                                
                                # Extract and execute Python code
                                code_start = answer.find("```python") + 10
                                code_end = answer.find("```", code_start)
                                code = answer[code_start:code_end].strip()
                                
                                # Show code in expander
                                with st.expander("View Code", expanded=False):
                                    st.code(code, language="python")
                                
                                # Execute the code
                                try:
                                    # Create namespace with data
                                    local_vars = {
                                        "data": st.session_state.data, 
                                        "df": st.session_state.data,
                                        "pd": pd, 
                                        "px": px, 
                                        "go": go, 
                                        "np": np
                                    }
                                    
                                    # Execute code
                                    exec(code, globals(), local_vars)
                                    
                                    # Check if code created a figure
                                    if 'fig' in local_vars and hasattr(local_vars['fig'], 'update_layout'):
                                        # Display the plot
                                        display_and_download_plotly(local_vars['fig'], "AI Generated Chart")
                                        
                                        # Get text after code block
                                        after_code = answer[code_end + 3:].strip()
                                        if after_code:
                                            st.markdown(after_code)
                                            
                                        # Add to message history with visualization
                                        st.session_state.messages.append({
                                            "role": "assistant",
                                            "content": before_code + (after_code if after_code else ""),
                                            "visualization": {
                                                "type": "plotly",
                                                "figure": local_vars['fig'],
                                                "title": "AI Generated Chart"
                                            }
                                        })
                                    else:
                                        # If no figure was created, check for DataFrame results
                                        result_vars = [var for var in local_vars if var not in ['data', 'df', 'pd', 'px', 'go', 'np']]
                                        if result_vars:
                                            for var in result_vars:
                                                if isinstance(local_vars[var], pd.DataFrame):
                                                    st.dataframe(local_vars[var], use_container_width=True)
                                                    
                                                    # Add to message history with dataframe
                                                    st.session_state.messages.append({
                                                        "role": "assistant",
                                                        "content": before_code + (answer[code_end + 3:] if code_end + 3 < len(answer) else ""),
                                                        "dataframe": local_vars[var]
                                                    })
                                                    break
                                            else:
                                                # No dataframe found, just show the answer
                                                st.markdown(answer[code_end + 3:] if code_end + 3 < len(answer) else "")
                                                st.session_state.messages.append({
                                                    "role": "assistant",
                                                    "content": answer
                                                })
                                        else:
                                            # No results found
                                            st.markdown(answer[code_end + 3:] if code_end + 3 < len(answer) else "")
                                            st.session_state.messages.append({
                                                "role": "assistant",
                                                "content": answer
                                            })
                                                
                                except Exception as e:
                                    st.error(f"Error executing code: {str(e)}")
                                    st.markdown(answer)
                                    st.session_state.messages.append({
                                        "role": "assistant",
                                        "content": answer
                                    })
                            else:
                                # Display the text response
                                st.markdown(answer)
                                st.session_state.messages.append({
                                    "role": "assistant",
                                    "content": answer
                                })
                
                except Exception as e:
                    st.error(f"Error processing query: {str(e)}")
                    st.session_state.messages.append({
                        "role": "assistant",
                        "content": f"I'm sorry, I encountered an error while processing your request: {str(e)}"
                    })
    
    # Example prompts
    with st.expander("Example Prompts"):
        st.markdown("""
        Try these example prompts:
        
        **Data Exploration:**
        - "Summarize this dataset for me"
        - "What are the main statistics for each column?"
        - "Show me the top 10 rows sorted by [column]"
        
        **Visualizations:**
        - "Show me a bar chart of [column]"
        - "Create a scatter plot of [column1] vs [column2]"
        - "Plot a histogram of [column]"
        - "Show me the correlation between all numeric columns"
        - "Create a pie chart showing the distribution of [column]"
        
        **Analysis:**
        - "Which [column] has the highest value?"
        - "Calculate the average [column] grouped by [another column]"
        - "Find outliers in [column]"
        - "Is there a relationship between [column1] and [column2]?"
        """)
else:
    # No file uploaded yet
    st.info("Please upload a CSV or Excel file to begin analysis.")
    
    st.markdown("""
    ## Welcome to Data Chat Assistant!
    
    This application helps you analyze and visualize your data through natural language conversations.
    
    **Features:**
    - 💬 **Chat with your data**: Ask questions and get instant insights
    - 📊 **On-demand visualizations**: Request charts and graphs when you need them
    - 📂 **Support for CSV and Excel**: Analyze data from various sources
    - 📱 **Interactive exploration**: Filter, sort, and explore your dataset
    - 💾 **Downloadable results**: Save your analyses and visualizations
    
    **To get started:**
    1. Upload a CSV or Excel file using the sidebar
    2. Ask questions about your data in the chat
    3. Request specific visualizations or analyses
    4. Download results for sharing or further analysis
    
    Need inspiration? Check out the "Example Prompts" section after uploading data!
    """)
    
    # Add example datasets
    with st.expander("Try Example Datasets"):
        st.markdown("""
        Don't have a dataset handy? Try one of these:
        """)
        
        col1, col2 = st.columns(2)
        
        with col1:
            st.markdown("### Titanic Dataset")
            st.write("Famous dataset with passenger information from the Titanic")
            if st.button("Load Titanic Dataset"):
                with st.spinner("Loading example dataset..."):
                    # Load Titanic dataset
                    import requests
                    url = "https://raw.githubusercontent.com/datasciencedojo/datasets/master/titanic.csv"
                    s = requests.get(url).content
                    titanic_df = pd.read_csv(io.StringIO(s.decode('utf-8')))
                    
                    # Save to session state
                    st.session_state.data = titanic_df
                    st.session_state.file_name = "titanic.csv"
                    st.rerun()
        
        with col2:
            st.markdown("### Iris Dataset")
            st.write("Classic dataset with flower measurements for three iris species")
            if st.button("Load Iris Dataset"):
                with st.spinner("Loading example dataset..."):
                    # Load Iris dataset
                    from sklearn.datasets import load_iris
                    iris = load_iris()
                    iris_df = pd.DataFrame(data=iris.data, columns=iris.feature_names)
                    iris_df['species'] = pd.Series(iris.target).map({
                        0: 'setosa', 
                        1: 'versicolor', 
                        2: 'virginica'
                    })
                    
                    # Save to session state
                    st.session_state.data = iris_df
                    st.session_state.file_name = "iris.csv"
                    st.rerun()