public class addNum {

    public static void main(String[] args){
System.out.println(add(2,7));
System.out.println(add(2,7,3));
System.out.println(add(2,7,3.5));

    }


        public static int add(int a ,int b) {
            return a + b;
        }
        public static int add(int a, int b, int c) {
            return a + b + c;
        }
    
    public static int add(int a , int b , double c){
        return(int) (a+b-c);
    }
    
}
