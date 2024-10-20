public class twoDArr {

    public static void main(String[] args) {
        int [][] arr = {
            {2,3,4,5},{3,5,26,7},{256,36,7,35},{23,75,85,35}
        };
        Transpose(arr);

        for (int idx = 0; idx < arr.length; idx++) {
            for(int j =0;j<arr[0].length;j++){
                System.out.print(arr[idx][j]+" ");
            }
            System.err.println("");  
        }
        
    }

    public static void Transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

         




    }
}