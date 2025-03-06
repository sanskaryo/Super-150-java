import java.util.*;

public class nextGreat {

    static int[] arr = {5,4,3,2,7,8,11,9,6};

    public static void main(String[] args) {
        int[] result = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
    
}



