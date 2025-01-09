public class printdec {

    public static void main(String[] args) {
        int n =5;
        Pd(n);
    }
    public static void Pd(int n ){
    if(n==0)return;

    Pd(n-1);
    System.out.println(n);

    //head recursion
    }
    
}
