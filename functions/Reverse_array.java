public class Reverse_array {

    public static void main(String[] args) {
        
        int[] arr = {3,5,2,1,4};
        reverse(arr);
        for(int i =0;i<arr.length;i++){
            System.err.print(arr[i] + "");
        }
    }
    public static void reverse(int[] arr){
        int i=0;
        int j = arr.length -1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
}
