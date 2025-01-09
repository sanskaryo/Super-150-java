public class headTail-recusrion {



    public static int sumHead(int n) {
        if (n == 0) {
            return 0;
        }
        // Recursive call first
        int partialSum = sumHead(n - 1);
        // Operation after the call
        return partialSum + n;
    }


    public static int sumTail(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }
        // Operation before the call
        return sumTail(n - 1, accumulator + n);
    }
    // Usage:
    // sumTail(5, 0) -> returns 15
    
}
