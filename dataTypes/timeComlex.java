public class timeComlex {


    public static void main(String[] args) {
        int n = 10000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            System.out.println("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
}
