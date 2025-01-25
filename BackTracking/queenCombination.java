



public class queenCombination {
	public static void main(String[] args) {
		int n =4;
		int tq =2; // total queen
		boolean[] board = new boolean[n];
		combination(board, tq, "",0,0);
	}
	public static void combination(boolean[] board, int tq, String ans,int qpsf,int index) {
		if(qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int i=0; i<board.length; i++) {
			if(board[i] != true) {
				board[i] = true;
				combination(board,tq,ans+"b"+i+"q"+qpsf,qpsf+1,i+1);
				board[i] = false;
			}
		}
	}

}