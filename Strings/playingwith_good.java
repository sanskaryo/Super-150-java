import java.util.*;

public class playingwith_good {

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
    }

    public static int Good_String(String s) {
        int ans = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                c++;
            } else {
                ans = Math.max(ans, c);
                c = 0;
            }
        }
        ans = Math.max(ans, c); 
        return ans;
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}