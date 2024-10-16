

public class pattern22 {

    public static void main(String[] args) {
       
        int n = 5;
        int star = n;
        int space = 0;
        int row = 1;
        
        while (row <= n) {
            int i = 1;
            while (i <= star) {
                System.out.print("* ");
                i++;
            }
            
            int j = 1;
            while (j < space) {
                System.out.print("  ");
                j++;
            }
            
            int k = 1;
            if (row == n) {
                k = 2;  // Skip printing the middle star on the last row
            }
            while (k <= star) {
                System.out.print("* ");
                k++;
            }
            
            System.out.println();
            row++;
            star--;
            space += 2;
        }
        
        
    }
}
