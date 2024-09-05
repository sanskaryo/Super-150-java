package dataTypes;

public class binarytodecimL {

    public static void main(String[] args) {
        int n = 100100;
        int sum =0;
        int m = 1;
        while(n>0) {
            int rem = n%10;
            sum = sum +rem*m;
            n=n/10;
            m = m*2;
        }
        System.out.println(sum);
    }
    
}
