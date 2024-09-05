

public class func2 {

    static int val = 100;


    public static void main(String[] args) {
        System.out.println("hello");

        int a =8;
        int b = 7;
        System.err.println(val );
        System.out.println(Add(a,b));
        System.out.println("Bye");
        
        
    }

    public static int Add(int a, int b) {
    
        int c = a+b;
        sub(c,a);
        return c;
    }
    public static void sub(int a , int b){

        int c = a-b;
        System.err.println(c);
    }

    
}
