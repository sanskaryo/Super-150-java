import java.util.Scanner;

public class YogurtSale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();  // Number of yogurts Maxim wants to buy
            int a = sc.nextInt();  // Price of one yogurt
            int b = sc.nextInt();  // Price of two yogurts on promotion

            int totalCost = 0;

            // If the promotion is cheaper than buying two yogurts at the regular price
            if (b < 2 * a) {
                totalCost += (n / 2) * b;  // Buy pairs of yogurts at the promotion price
                if (n % 2 == 1) {
                    totalCost += a;  // Buy one more yogurt at regular price if odd number of yogurts
                }
            } else {
                totalCost = n * a;  // Buy all yogurts at the regular price
            }

            System.out.println(totalCost);  // Output the minimum cost for this test case
        }

        sc.close();
    }
}

    

