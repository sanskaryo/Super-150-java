import java.util.*;

public class Main {

    public static int searchInsert(int [] arr, int x) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }
}