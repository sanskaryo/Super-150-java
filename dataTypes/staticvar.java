public class staticvar {


    

    public static void main(String[] args) {
        System.out.println(Add(2,7));
        int val =100;
        System.out.println(val);
    }

 
    public static int Add(int a , int b) {
        int val = 90;
        Static_fun.val = Static_fun.val +5;
        return a+b;
    }

}

class Static_fun {
    public static int val = 100;
}
