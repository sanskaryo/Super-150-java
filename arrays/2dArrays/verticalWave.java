public class verticalWave {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int n = arr.length;
        int m = arr[0].length;
        for(int j=0;j<m;j++){
            if(j%2==0){
                for(int i=0;i<n;i++){
                    System.out.print(arr[i][j] + " ");
                }
            }
            else{
                for(int i=n-1;i>=0;i--){
                    System.out.print(arr[i][j] + " ");
                }
            }
        }

        
    }
    
}
