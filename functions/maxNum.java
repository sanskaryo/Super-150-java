public class maxNum {

    public static void main(String[] args) {
        int [] arr = {4,6,3,8,4,7,10};
        int max = findMax2(arr);
        System.out.println("The maximum number is: " + max);


    }

    // public static int findMax(int[] arr) {
    //     int max = arr[0]; 
    //     for (int i = 1; i < arr.length; i++) {
    //         if (arr[i] > max) {
    //             max = arr[i]; 
    //         }
    //     }
    //     return max;
    // }


    public static int findMax2(int[] arr) {
        int max = Integer.MIN_VALUE; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = Math.max(max,arr[i]); 
            }
        }
        return max;
    }
    
}
