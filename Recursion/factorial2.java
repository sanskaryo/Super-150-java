public class factorial2 {

    public static void main(String[] args) {
      int n =5;

      System.out.print(fact(n));


    }


    public static int fact(int n ){


        // if(n==1 || n==0){
        //     return 1;
        // }

        int fn = fact(n-1);
        return fn*n;


    }
    
}
