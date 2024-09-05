import java.util.*;

public class fun4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        
        int result = linearSearch(arr, key);
        if(result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
        
        Display(arr);
    }

    public static void Display(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int linearSearch(int[] arr, int key) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i; // Return the index of the found element
            }
        }
        return -1; // Element not found
    }
}