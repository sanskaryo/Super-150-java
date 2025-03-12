import java.util.Scanner;

public record ThirdSide() {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        while (tests-- > 0) {
            int size = sc.nextInt();
            int max1 = 0, max2 = 0;

            for (int i = 0; i < size; i++) {
                int num = sc.nextInt();
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max2 = num;
                }
            }

            System.out.println(max1 + max2);
        }

    }
    
}
