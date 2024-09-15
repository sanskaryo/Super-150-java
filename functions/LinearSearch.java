public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target element
            }
        }
        return -1; // Target element not found
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 12, 1};
        int targetValue = 8;
        int index = linearSearch(numbers, targetValue);
        if (index == -1) {
            System.out.println("Target element not found in the array.");
        } else {
            System.out.println("Target element found at index: " + index);
        }
    }
}
