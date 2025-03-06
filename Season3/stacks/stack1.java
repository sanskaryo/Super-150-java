import java.util.Stack;

public class stack1 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(80);
        st.push(90);
        st.push(79);
        st.push(99);
        st.push(101);

        // Uncomment these lines to test stack operations
        System.out.println(st.capacity());
        System.out.println(st);
        // System.out.println(st.peek());
        // System.out.println(st);
        // System.out.println(st.pop());
        // System.out.println(st);
        // System.out.println(st.isEmpty());
        // System.out.println(st.size());

        // Test the Add_last method
        Add_last(st, 500);
        System.out.println(st);
        Reverse(st);
        System.out.println(st);
    }

    public static void Reverse(Stack<Integer>st){
        if(st.isEmpty()){
            return;
        }
        int x = st.pop();
        Reverse(st);
        Add_last(st,x);
    }

    public static void Add_last(Stack<Integer> st, int item) {
        if (st.isEmpty()) {
            st.push(item);
            return;
        }
        int x = st.pop();
        Add_last(st, item);
        st.push(x);
    }
}
