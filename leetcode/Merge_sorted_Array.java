public class Merge_sorted_Array {

    public static void main(String[] args) {
        
        int[] arr = {2,3,5,7,8};
        int[] arr1 = {1,3,5,7,8,9};
        int[] a = Merge_two_Array(arr, arr1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }

    }

    public static int[] Merge_two_Array(int[] arr, int[] arr1){
        int n = arr.length;
        int m = arr1.length;
        int[] ans = new int[n+m];
        int i=0,j=0,k=0;
        while(i<n  && j<m){
            if(arr[i] <arr1[j]){
                ans[k] = arr1[j];
                k++;
                i++;
            }
            else{
                ans[k] = arr1[j];
                k++;
                j++;
            }
        }

        while(i<n){
            ans[k] = arr1[i];
            k++;
            i++;
        }
        while(j<m){
            ans[k] = arr1[j];
            k++;
            j++;
        }
        return ans;
    }
    
}
