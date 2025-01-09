public class MaxSumPath {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 7, 10, 12, 15, 30, 34};
        int[] arr2 = {1, 5, 7, 8, 10, 15, 16, 19};

        int result = findMaxSumPath(arr1, arr2); // Call the corrected method
        System.out.println("The maximum sum path is: " + result);
    }

    // Corrected method signature with a proper return type and name
    public static int findMaxSumPath(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int s1 = 0, s2 = 0;
        int ans = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                s1 += arr1[i]; // Accumulate sum of arr1 until the common element
                i++;
            } else if (arr1[i] > arr2[j]) {
                s2 += arr2[j]; // Accumulate sum of arr2 until the common element
                j++;
            } else {
                // Common element found
                s1 += arr1[i]; // Add the common element to the sums
                s2 += arr2[j];
                ans += Math.max(s1, s2); // Add the maximum of the two sums to the result
                i++;
                j++;
                s1 = 0; // Reset sums for the next segment
                s2 = 0;
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.length) {
            s1 += arr1[i];
            i++;
        }

        // Add remaining elements from arr2
        while (j < arr2.length) {
            s2 += arr2[j];
            j++;
        }

        ans += Math.max(s1, s2); // Add the maximum of the remaining sums
        return ans;
    }
}
