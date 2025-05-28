import java.util.*;

public class stringsquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String s = sc.nextLine();
            int target = Integer.parseInt(s);

            int sqrt = (int)Math.sqrt(target);
            if (sqrt * sqrt != target) {
                System.out.println("-1");
                continue;
            }

            // Now we know target is a perfect square, try all (a + b = sqrt)
            boolean found = false;
            for (int a = 0; a <= sqrt; a++) {
                int b = sqrt - a;
                if (a >= 0 && b >= 0) {
                    System.out.println(a + " " + b);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("-1");
            }
        }
    }
}
