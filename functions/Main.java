import java.util.*;  // Importing the Scanner class for user input

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object to take input from the user
        int[] numbers = new int[1000];  // An array to store up to 1000 integers
        int cuSum = 0;  // Variable to store cumulative sum
        int index = 0;  // This index is used to keep track of where to insert the next number in the array

        // While loop runs until input ends or the cumulative sum becomes negative
        while (scanner.hasNext()) {  // This loop will keep running as long as there's input
            int num = scanner.nextInt();  // Read the next number from the input
            cuSum += num;  // Add the number to the cumulative sum

            if (cuSum >= 0) {  // Check if the cumulative sum is non-negative
                numbers[index] = num;  // If yes, store the number in the array
                index++;  // Increment the index for the next number
            } else {  // If cumulative sum goes negative, stop taking input
                break;  // Exit the loop
            }
        }

        // Loop to print the stored numbers in the array
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);  // Print each number that was stored
        }
    }
}
