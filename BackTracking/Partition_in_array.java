// public class Partition_in_array {
    
//     public static void main(String[] args) {
//         int[] arr = {5,7,2,1,8,9,3};
//         int pivot = arr[arr.length-1];
//         int pi = partition(arr, 0, arr.length-1);
//         System.out.println("Pivot index: " + pi);
//         for(int val : arr) {
//             System.out.print(val + " ");
//         }
//     }
    
//     public static int partition(int[] arr, int start, int end) {
//         int pivot = arr[end];
//         int i = start - 1; // Index for smaller elements
        
//         for(int j = start; j < end; j++) {
//             // If current element is smaller than pivot
//             if(arr[j] < pivot) {
//                 i++;
//                 // Swap arr[i] and arr[j]
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }
        
//         // Place pivot in its final position
//         int temp = arr[i + 1];
//         arr[i + 1] = arr[end];
//         arr[end] = temp;
        
//         return i + 1; // Return pivot's position
//     }
// }


public class Partition_in_array {

    public static void main(String[] args){

        int[] arr = {5,7,3,2,1,8,4};
        int idx = Partition(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(idx);
    }

    public static int Partition(int[] arr, int si, int ei){
        int item = arr[ei];
        int idx = si;
        for(int i=si;i<ei;i++){
            if(arr[i] <item){
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp ;
                idx++;

                
            }
        }
int temp = arr[ei];
arr[ei] = arr[idx];
arr[idx] = temp;
return idx;


    }
}