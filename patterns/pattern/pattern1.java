

public class pattern1 {

    public static void main(String[] args) {
        int n = 5;

        int row = 1;
        while (row <= n) {
            int space = 1;
            while (space <= (n - row)) {
                System.out.print(" ");
                space++;
            }
            
            int star = 1;
            while (star <= row) {
                System.out.print("* ");
                star++;
            }
            
            System.out.println();
            row++;
        }
    }
}
