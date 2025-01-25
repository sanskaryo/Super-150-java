public class backTrack1 {

    public static void main(String[] args) {
        int n = 4; // Board size
        int tq = 2; // Total queens to place
        boolean[] board = new boolean[n];

        Permutation(board, tq, "", 0);
    }

    public static void Permutation(boolean[] board, int tq, String ans, int qpsf) {
        
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!board[i]) { 
                board[i] = true; 
                Permutation(board, tq, ans + "b" + i + "q" + qpsf + " ", qpsf + 1); // Recur
                board[i] = false; 
            }
        }
    }
}
