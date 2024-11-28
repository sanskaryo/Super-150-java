

public class slide2 {

    public static void main(String[] args) {
        int [] arr = {2,3,1,1,5,7,8,9};

        int k =3;
    }

    public static int Max_window(int[] arr,int k){
        int sum =0,ans=0;
        for(int i=0;i<k;i++){

        }
        ans=sum;
        for(int i=k;i<arr.length;i++){
            sum += arr[i];
            sum -=arr[i-k];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
    
}


