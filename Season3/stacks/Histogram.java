import java.util.*;

public class Histogram {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int maxArea = Largest_area(arr);
        System.out.println("Largest rectangle area: " + maxArea);
    }

    public static int Largest_area(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int n = arr.length;
        
        // Process each bar of the histogram
        for (int i = 0; i < n; i++) {
            // If current bar is lower than the bar at top of the stack,
            // calculate area with the bar at top as height.
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int height = arr[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            st.push(i);
        }
        
        // Process the remaining bars in the stack
        while (!st.isEmpty()) {
            int height = arr[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            ans = Math.max(ans, height * width);
        }
        
        return ans;
    }
}