public class bookAllocation {

    public static void main(String[] args) {
        int[] page = {10, 20, 30, 40};
        int nos= 2;
        System.out.println(minPages(page, nos));
    }

    public static int minPages(int[] arr, int m) {
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < arr.length; i++) {
            hi += arr[i];
        }
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(arr, m, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] arr, int m, int mid) {
        int student = 1;
        int readPage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (readPage + arr[i] <= mid) {
                readPage += arr[i];
            } else {
                student++;
                if (student > m || arr[i] > mid) {
                    return false;
                }
                readPage = arr[i];
            }
        }
        return true;
    }
    
}
