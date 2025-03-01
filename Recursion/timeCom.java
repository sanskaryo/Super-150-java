import java.util.*;

public class timeCom {

    public static void main(String[] args) {
        
        int si =10;

        int ei =100;
        Random rn = new Random();
        for(int i=0;i<10;i++){
       
  
                int x = rn.nextInt(ei-si+1)+si; // si add nhi karenge to ye ei-si m jinta no hoga 0 se vaha tak ka no dega 
                System.out.println(x);
            }
        }
    }
    

