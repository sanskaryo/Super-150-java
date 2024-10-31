package SPOJ;

import java.util.Arrays;
import java.util.Scanner;

public class aggcows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        int n = sc.nextInt();


        int[] stall = new int[n];
   
        for (int i = 0; i < n; i++) {
            stall[i] = sc.nextInt();
        }

    
        int noc = sc.nextInt();


        Arrays.sort(stall);

        System.out.println( largest_min(stall, noc));

        sc.close();
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