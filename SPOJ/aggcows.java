package SPOJ;

import java.util.Arrays;

public class aggcows {

    public static void main(String[] args) {
        int[] stall = {1, 2, 3, 8, 4, 9};
        int noc = 3;
        Arrays.sort(stall);
        System.out.println(largest_min(stall, noc));
    }

    public static int largest_min(int[] stall, int noc) {
        int lo = 0;
        int high = stall[stall.length - 1] - stall[0];
        int ans = 0;
        while (lo <= high) {
            int mid = (lo + high) / 2;
            if (isPossible(stall, noc, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] stall, int noc, int mid) {
        int pos = stall[0];
        int cow = 1;
        for (int i = 1; i < stall.length; i++) {
            if (stall[i] - pos >= mid) {
                cow++;
                pos = stall[i];
            }
            if (cow == noc) {
                return true;
            }
        }
        return false;
    }
}






