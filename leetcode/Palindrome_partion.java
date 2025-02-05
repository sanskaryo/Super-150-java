import java.util.*;

public class Palindrome_partion {
    public static void main(String[] args) {
        String ques = "nitin";
        List<List<String>> ans = new ArrayList<>();
        List<String> ll = new ArrayList();
        Partioning(ques, ll,ans);
        System.out.print(ans);
    }

    public static void Partioning(String ques, String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int cut =1;cut<=ques.length();cut++){
            String s = ques.substring(0,cut);
            if (isPalindrome(s))
            Partioning(ques.substring(cut), ans+s+"|");
        }
    }

    public static boolean isPalindrome(String s){

        int left=0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}
