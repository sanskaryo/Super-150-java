import java.util.Scanner;

public class LittleNikita {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(isPossible(n, m) ? "Yes" : "No");
        }
    }

    private static boolean isPossible(int n, int m) {
      
        return m <= n && (m % 2 == n % 2);
    }
}
