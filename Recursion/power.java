public class power {

    public static void main(String[] args) {

        int n =3;
        int m =4;
        System.out.print(pow(n, m));
    }

    public static int pow(int a, int n ){

        if(n==0){
            return 1;   // if base case not given then call stack full - stack overflow , thats why we set if n==0 , return 1 kyuki bhai a^0 1 hi to hoti h 

        }
        return a*pow(a,n-1);

        }
        


    }
    
