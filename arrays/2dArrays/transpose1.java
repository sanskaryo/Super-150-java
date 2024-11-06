import java.util.Scanner;

public class transpose1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
      
        int row = sc.nextInt();
        int col = sc.nextInt();
        
   
        int[][] matrix = new int[row][col];
        
        
       
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
      
        
     
        int[][] transposedMatrix = transpose(matrix, row, col);
        
    
        System.out.println("Transposed Matrix:");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
   
    }

    static int[][] transpose(int[][] matrix, int r, int c) {
        int[][] ans = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}