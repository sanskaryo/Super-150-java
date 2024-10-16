public class productof_array_except_self {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] ans = productExceptSelf(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Initialize left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }

        // Initialize right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr[i + 1] * right[i + 1];
        }

        // Construct the result array
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}