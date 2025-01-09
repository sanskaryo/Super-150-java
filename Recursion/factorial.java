import java.util.*;
public class factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(facto(a));
    }   

    public static int facto(int n) {

        if(n==1 || n==0){
            return 1;
        }

       int fact_nm = facto(n-1);                                                                                    // n-1 ko call lagaenge 
       int fact = n*fact_nm;
       return fact;
    }
}
