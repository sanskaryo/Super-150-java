import java.util.*;

public class asum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int z = sc.nextInt();

            if(n == p+z || p == n+z || z == p+n){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
                
            }}



            
    }
    
}

