
public class searchInsert {

    public static int search(int [] arr, int x) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
       
            if (arr[mid] >= x) {
                ans = mid;
            
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
        int ind = search(arr, x);
        System.out.println("The index is: " + ind);
    }
}