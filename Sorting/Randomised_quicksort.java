import java.util.*;

public class Randomised_quicksort {

    public static void main(String[] args) {
        
        int[] arr = {5,7,4,6,2,1,8,4};
        Sort(arr,0,arr.length-1);
    }

    public static void Sort(int[] arr ,int si,int ei){

        if(si>=ei){
            return;
        }
        int idx = Partition(arr, si, ei);
        Sort(arr,si,idx-1);
        Sort(arr,idx+1,ei);
    }

    public static int Partition(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
        Random rn = new Random();
        int ri =rn.nextInt(ei-si)+si;
        int tt=arr[ei];
        arr[ei] =  arr[ri];
        arr[ri] =  tt;

		int item = arr[ei];
		int idx = si;
		for (int i = si; i < ei; i++) {
			if (arr[i] <= item) {
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				idx++;
			}
		}
		int temp = arr[ei];
		arr[ei] = arr[idx];
		arr[idx] = temp;
		return idx;

	}
    
}
