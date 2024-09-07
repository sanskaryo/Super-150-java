import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        int[] nums = new int[size];

        // Input array elements
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        // Reverse the array
        int start = 0;
        int end = size - 1;
        
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        // Print the reversed array
        System.out.println("Reversed array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

