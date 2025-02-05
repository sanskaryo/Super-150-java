public class Subsequence {

    public static void main(String[] args) {
        String ques = "abc";
        print(ques, "");
    }

    public static void print(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String remaining = ques.substring(1);
        
        // Include current char
        print(remaining, ans + ch);
        // Exclude current char  
        print(remaining, ans);
    }
}