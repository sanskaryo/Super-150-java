public class Palindrome_partion {


    public static void main(String[] args) {
        String ques = "nitin";
    }

    public static void Partioning(String ques, String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int cut =1;cut<=ques.length();cut++){
            String ans = ques.substring(0,cut);
            Partioning(ques.substring(cut), ans+s+"|");
        }
    }
    
}
