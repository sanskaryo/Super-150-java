public class GenerateParenthesis {
    

    public void main(String[] args){

        int n =3;
        Parenthesis(n,0,0,"");
    }

    public static void Parenthesis(int n=0,int closed, int open,String ans){


        if(open==n && closed==n){
            System.out.print(ans);
            return;
        }

        if(open>n || closed > open){
            return;
        }
    }
}
