
import java.util.*;

public class SlidingWindowProblem {
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int start = 0, maxLength = 0, maxCount = 0;
        int[] charCount = new int[26];

        for (int end = 0; end < n; end++) {
            charCount[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(end) - 'A']);

            while ((end - start + 1) - maxCount > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k)); // Output: 4 ("AABA" or "ABBA")
    }
}
