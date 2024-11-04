public class Rotateimage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // Start from j = i to avoid redundant swaps
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // Use two-pointer technique to reverse the row
            int left = 0;
            int right = n - 1;
            while (left < right) {
                // Swap matrix[i][left] with matrix[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Helper method to print the matrix (for visualization)
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        ri.printMatrix(matrix);

        ri.rotate(matrix);

        System.out.println("\nRotated Matrix by 90° Clockwise:");
        ri.printMatrix(matrix);
    }
}
