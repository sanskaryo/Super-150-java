
import java.util.*;

public class notPalindromic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); // flush newline

        while (testCases-- > 0) {
            int length = scanner.nextInt();
            int goodPairTarget = scanner.nextInt();
            scanner.nextLine(); // flush newline
            String binaryString = scanner.nextLine();

            int zeroCount = 0;
            int oneCount = 0;

            for (char ch : binaryString.toCharArray()) {
                if (ch == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            int totalPairs = length / 2;
            int badPairsNeeded = totalPairs - goodPairTarget;

            // Not enough 0s or 1s to make required bad pairs
            if (zeroCount < badPairsNeeded || oneCount < badPairsNeeded) {
                System.out.println("NO");
                continue;
            }

            int remainingZeros = zeroCount - badPairsNeeded;
            int remainingOnes = oneCount - badPairsNeeded;

            int goodPairsFromZeros = remainingZeros / 2;
            int goodPairsFromOnes = remainingOnes / 2;

            int totalGoodPairsPossible = goodPairsFromZeros + goodPairsFromOnes;

            if (totalGoodPairsPossible >= goodPairTarget) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
    
}
