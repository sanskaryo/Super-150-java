package Assignments;

public class Search-a-2dMatrix {
    


    public static void main(String[] args) {
        int row =0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==target){
                return true;
            }
            else if(arr[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
    }
    
}
