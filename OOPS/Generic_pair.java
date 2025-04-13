public class Generic_pair <T, U> {


   T x;
   U y;


   public Pair (T x, U y) {
       this.x = x;
       this.y = y;
   }
   public T getX() {
       return x;
   }

   public static void main (String[] args) {
       Pair<Integer, String> p1 = new Pair<>(1, "apple");
       System.out.println("(" + p1.getX() + ", " + p1.getY() + ")");
   }

    
}
