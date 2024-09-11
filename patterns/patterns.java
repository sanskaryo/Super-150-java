public class patterns {

    public static void main(String[] args) {
        pattern1(4); // Function call to pattern1 with n = 4
    }

    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) { // Outer loop for rows
            for (int col = 1; col <= i; col++) { // Inner loop for columns (stars)
                System.out.print("*"); // Print star
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
