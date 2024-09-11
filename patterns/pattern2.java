public class pattern2 {
    public static void main(String[] args) {
        int n = 5;

        // First Row
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // Middle Rows
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - i - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Last Row
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}

