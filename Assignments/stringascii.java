import java.util.Scanner;

public class stringascii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        String s = sc.next();  
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            result += currentChar;  

            if (i < s.length() - 1) {
                char nextChar = s.charAt(i + 1);
                int difference = (int) nextChar - (int) currentChar;
                result += difference;  
            }
        }

        System.out.println(result);

        sc.close();  // Close the scanner
    }
}