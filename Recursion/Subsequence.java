
// ## spinal cord of recursion - SUBSEQUENCE

public class Subsequence {

    public static void main(String[] args) {
        
         String ques="abc";
         print(ques,"");
    }

    public static void print(String ques, String ans){

        if(ques.length()==0){
            return;
        }

        char ch = ques.charAt(0);
        print(ques.substring(1),ans);
        print(ques.substring(1),ans+ch);

    }
    
}