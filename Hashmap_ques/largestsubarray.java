import java.util.*;


public class largestsubarray {

    int zeroSumLargestsubarray (int[] arr, int n ){
        HashMap<Integer,Integer> map = new HashMap<>();

        int maxLength = 0;
        int preSum=0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++)
{
                    preSum += arr[i];
            if(map.containsKey(preSum)){
                int length = i - map.get(preSum);
                maxLength = Math.max(maxLength,length);
            }else{
                map.put(preSum,i);
            }
        }
        return maxLength;
    }
}