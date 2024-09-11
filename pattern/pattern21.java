import java.util.Scanner;

public class pattern21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int star = 1;
        int space = 2 * n - 3;
        int row = 1;
        
        while (row <= n) {
            int i = 1;
            while (i <= star) {
                System.out.print("* ");
                i++;
            }
            
            int j = 1;
            while (j <= space) {
                System.out.print("  ");  // Print two spaces to maintain alignment
                j++;
            }
            
            int k = 1;
            // Special case for the first row to avoid duplicating the star in the middle
            if (row == 1) {
                k = 2;  // Skip printing the middle star
            }
            while (k <= star) {
                System.out.print("* ");
                k++;
            }
            
            System.out.println();
            row++;
            star++;
            space -= 2;
        }
        
        sc.close();  // Closing the Scanner to prevent resource leaks
    }
}
