
public class moore_voting {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int majorityElement = findMajorityElement(arr, n);
        System.out.println("Majority Element: " + majorityElement);
    }

    public static int findMajorityElement(int[] arr, int n) {
        int majorityElement = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                majorityElement = arr[i];
                count = 1;
            } else if (arr[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
        }


return majorityElement;

    
}

}
