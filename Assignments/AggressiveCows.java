import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number of elements and required count `c`
        int n = scanner.nextInt();
        int requiredCount = scanner.nextInt();
        
        int[] elements = new int[n];
        
        // Populate array
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }
        
        // Sort array
        Arrays.sort(elements);
        
        // Print result
        System.out.println(findMaxDistance(elements, requiredCount));
    }

    private static int findMaxDistance(int[] elements, int requiredCount) {
        int low = 0;
        int high = elements[elements.length - 1] - elements[0];
        int maxDistance = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canPlaceCows(mid, requiredCount, elements)) {
                maxDistance = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxDistance;
    }

    private static boolean canPlaceCows(int distance, int requiredCount, int[] elements) {
        int count = 1;
        int lastPosition = elements[0];

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] - lastPosition >= distance) {
                lastPosition = elements[i];
                count++;

                // If required number of cows have been placed
                if (count == requiredCount) {
                    return true;
                }
            }
        }

        return false;
    }
}
