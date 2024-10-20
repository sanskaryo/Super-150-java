
public class checkerboard {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(args[i + 1]);
            printCheckerboard(n);
        }
    }

    public static void printCheckerboard(int n) {
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
