import java.util.*;

public class BookAllocation {

    // Helper function to check if a maxPages value can work
    public static boolean canAllocateBooks(int[] books, int M, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;
        
        for (int i = 0; i < books.length; i++) {
            currentSum += books[i];
            if (currentSum > maxPages) {
                studentCount++;
                currentSum = books[i];
                if (studentCount > M) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to find the minimum of the maximum pages allocated to a student
    public static int bookAllocation(int[] books, int M) {
        int low = Arrays.stream(books).max().getAsInt(); // Max book pages (minimum possible max pages)
        int high = Arrays.stream(books).sum(); // Sum of all book pages (maximum possible max pages)

        int result = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocateBooks(books, M, mid)) {
                result = mid;
                high = mid - 1; // Try for a smaller max pages
            } else {
                low = mid + 1; // Increase the max pages if current allocation doesn't work
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input for the Book Allocation Problem
        int M = sc.nextInt(); // Number of students
        int N = sc.nextInt(); // Number of books
        int[] books = new int[N];
        
        for (int i = 0; i < N; i++) {
            books[i] = sc.nextInt(); // Pages in each book
        }

        // Finding the optimal book allocation
        int result = bookAllocation(books, M);
        System.out.println("Minimum max pages a student can read: " + result);
    }
}
