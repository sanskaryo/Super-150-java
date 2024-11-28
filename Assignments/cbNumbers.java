import java.util.*;

public class cbNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        PrintSubString(s);
        sc.close(); // Close the scanner
    }

    public static void PrintSubString(String s) {
        int c = 0;
        boolean[] visited = new boolean[s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int j = len; j <= s.length(); j++) {
                int i = j - len;
                long num = Long.parseLong(s.substring(i, j));
                if (isCbNumber(num) && isVisited(visited, i, j)) {
                    c++;
                    for (int k = i; k < j; k++) {
                        visited[k] = true;
                    }
                }
            }
        }
        System.out.println(c);
    }

    public static boolean isVisited(boolean[] visited, int i, int j) {
        for (int k = i; k < j; k++) {
            if (visited[k]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCbNumber(long n) {
        if (n == 0 || n == 1) {
            return false;
        }

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int prime : primes) {
            if (n == prime) {
                return true;
            }
        }

        for (int prime : primes) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}