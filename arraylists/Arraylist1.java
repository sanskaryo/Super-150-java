import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Arraylist1 {


    public static void main(String[] args) {
        ArrayList<Integer> ll =  new ArrayList<>();
        ll.add(10);
        ll.add(20);
        ll.add(56);
        ll.add(1,15);

        ll.set(0,5);
        ll.remove(1);
        System.out.println(ll);
        System.out.print(ll.get(2));
        System.err.println(ll.set(0,4));
      

        System.out.println(ll);
        for(int i=0;i<ll.size();i++){
            System.out.print(ll.get(i)+" ");
        }
        System.err.println();

        int[] arr = new int [5];
        for(int v:ll){
            System.out.print(v+" ");
        }

        Collections.sort(ll);
        Collections.reverse(ll);
        System.out.print(ll);
    }
    
}
