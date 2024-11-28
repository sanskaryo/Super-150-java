import java.util.*;

public class deletesamenum {

    public static String deletesame(String s) {

        int i = 0;
        int j = 0;

        
        String newElements = "";

        while (j < s.length()) {
           
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            else {
                newElements += s.charAt(i);
               
                i = j;
                j++;
            }
        }

       
        newElements += s.charAt(j - 1);
        return newElements;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = deletesame(s);
        System.out.print(res);
        sc.close(); // Close the scanner
    }
}