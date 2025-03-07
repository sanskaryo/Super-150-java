
import java.util.Scanner;



public class spiralMatrix1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        printSpiral(matrix, row, col);
    }


    static void printSpiral(int[][] matrix, int r, int c) {
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int totalElements = 0;

        while (totalElements < r * c) {
            for (int j = left; j <= right && totalElements < r * c; j++) {
                System.out.print(matrix[top][j] + " ");
                totalElements++;
            }
            top++;

            //right col - top row- bottom row

            for (int i = top; i <= bottom && totalElements < r * c; i++) {
                System.out.print(matrix[i][right] + " ");
                totalElements++;
            }
            right--;

            //bottom row --> right col - left col 

            for (int j = right; j >= left && totalElements < r * c; j--) {
                System.out.print(matrix[bottom][j] + " ");
                totalElements++;
            }
            for (int i = bottom; i >= top && totalElements < r * c; i--) {
                System.out.print(matrix[i][left] + " ");
                totalElements++;
            }
            left++;
        }



    
}

}
