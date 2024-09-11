public class pattern14 {

    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int row = 1;
        int space = 
        
        while (row <= 2 * n - 1) {
            int i = 1;
            while (i <= star) {
                System.out.print("* ");
                i++;
            }
            
            if (row < n) {
                star++;
            } else {
                star--;
            }

            // Move to the next row
            System.out.println();
            row++;
        }
    }
}
