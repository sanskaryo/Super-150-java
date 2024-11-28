import java.util.Scanner;

public class stringcompress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(compressString(input));
        scanner.close();
    }
    
    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // If we're at the last character or current character is different from next
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        return compressed.toString();
    }
}
