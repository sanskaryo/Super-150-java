
import java.util.*;

public class Substring_length {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
       String str = "codingblocks";
       PrintSubString(str);
    }


    public static void PrintSubString(String str){
        for(int len =1;len<=str.length();len++){
            for(int start = 0;start<=str.length()-len;start++){
                int end = start+len;
                System.out.println(str.substring(start,end));
            }
        }
    
}

}
