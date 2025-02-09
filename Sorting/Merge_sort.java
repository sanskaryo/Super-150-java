public class Merge_sort {

    public static void main(String[] args) {

        int[] arr = {5,7,3,4,2};

        

    }

    public static int[] Sort (int[] arr , int si, int ei){
        if(si==ei){
            int[] bs = new int[1];
            bs[0] = arr[si];
            return bs;
        }
        
        int mid = (si+ei)/2;
        int[] a = Sort(arr,si,mid);
        int[] b = Sort(arr,mid+1,ei);
        return Merge_two_Array(a,b);


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
