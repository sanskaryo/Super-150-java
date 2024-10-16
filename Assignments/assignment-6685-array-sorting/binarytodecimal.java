import java.util.Scanner;

public class binarytodecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String String1 = scanner.next();
        int decimalNumber = Integer.parseInt(String1, 2);
        System.out.println("Decimal Equivalent: " + decimalNumber);
    }
}
