// sum of n natural no using recursion

public class rec2 {
    public static int printSum(int i, int n, int sum) {
        if (i > n) {
            return sum;
        }
        return printSum(i + 1, n, sum + i);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = printSum(1, n, 0);
        System.out.println(result);
    }
}