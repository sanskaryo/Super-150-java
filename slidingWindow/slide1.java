

public class slide1 {
    public static int maxSum(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Invalid");
            return -1;
        }

        
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }

        
        int window_sum = max_sum;
        for (int i = k; i < arr.length; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Maximum sum of " + k + " consecutive elements is " + maxSum(arr, k));
    }
}



