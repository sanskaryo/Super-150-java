

import java.util.Scanner;

public class tripppi {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while(t-->0){

            String s = sc.nextLine().trim();
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();

            for(String word : arr){
                if(!word.isEmpty ()){
                    sb.append(word.charAt(0));
                }
            }
System.out.println(sb.toString().toLowerCase ());



        }

    }
        
    
}
