import java.util.*;

public class Draw {  

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        while(a-->0){

            int l= sc.nextInt();
            int r= sc.nextInt();
            int d= sc.nextInt();
            int u= sc.nextInt();

            if(l==r && d==u && d==u){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
        
            
        }
    }




