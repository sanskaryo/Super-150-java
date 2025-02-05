import java.util.*;

// public class RatChasesCheese {

//     public static void main(String[] args) {
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         char[] [] maze = new char[n][m];

//         for(int i=0;i<maze.length;i++){
//             String s = sc.next();
//             for(int j=0;j<maze[0].length;j++){
//                 maze[i][j] =s.charAt(j);
//             }
//         }
//         print(maze,0,0);
//     }

//     public static void print(char[][] maze,int cr, int cc){
//         if(cr<0 || cr>maze.length || cc >= maze[0].length || maze[cr][cc]=='X'){
//             return;
//         }
//         if(cr ==maze.length-1 && cc == maze[0].length-1){
//             display(ans);
//         }
//         maze[cr][cc] ="X";
//         ans[cc][cc] =1;
//         print(maze,cr-1,cc);
//         print(maze,cr,cc-1);
//         print(maze,cr+1,cc);
//         print(maze,cr,cc+1);
//         maze[cr][cc]="O";
//     }

// public static void display(int[][] ans){
//     for(int =0;i<ans.length;i++){
//         for(int j=0;j<ans.length[0];j++){
//             System.out.println(ans[i][j]+" ");
//         }
//         System.out.print();
//     }
// }

// }

public class RatChasesCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] maze = new char[n][m];
		for(int i=0;i<maze.length;i++) {
			String s = sc.next();
			for(int j=0;j<maze[0].length;j++) {
				maze[i][j] = s.charAt(j);
			}
		}
		int[][] ans=new int[n][m];
		print(maze,0,0,ans);
		if(val==false) {
			System.out.println("NO PATH FOUND");
		}

	}
	static boolean val=false;
	public static void print(char[][] maze,int cr,int cc,int[][] ans) {
		if(cr<0 || cc<0 || cr==maze.length || cc==maze[0].length || maze[cr][cc]=='X') {
			return;
		}
		if(cr==maze.length-1 && cc==maze[0].length-1) {
			ans[cr][cc]=1;
			val=true;
			display(ans);
		}
		maze[cr][cc]='X';
		ans[cr][cc]=1;
		
		print(maze,cr-1,cc,ans);
		print(maze,cr,cc-1,ans);
		print(maze,cr+1,cc,ans);
		print(maze,cr,cc+1,ans);
		
		maze[cr][cc]='O';
		ans[cr][cc]=0;
	}
	
	public static void display(int[][] ans) {
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}