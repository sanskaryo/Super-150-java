
import java.util.Scanner;

public class rook {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i=0;i<t;i++){
        String position = sc.nextLine();
        getMoves(position);
    }

}

public static void getMoves(String position){
    char column = position.charAt(0);
    char row = position.charAt(1);

    for(char r = '1';r<='8';r++){
        if(r!=row){
            System.out.println(column+""+r);
        }
    }


    
    for(char c = 'a'; c<='h';c++){
        if(c!=column){
            System.out.println(c+""+row);
        }
    }
    System.out.println("");
}
    
}
