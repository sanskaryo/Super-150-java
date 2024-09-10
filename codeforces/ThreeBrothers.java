import java.util.Scanner;

public class ThreeBrothers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two integers a and b
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // Calculate the missing brother's number
        int lateBrother = 6 - (a + b);
        
        // Output the result
        System.out.println(lateBrother);
        
        sc.close();
    }
}
