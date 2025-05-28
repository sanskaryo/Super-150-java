import java.util.ArrayList;

public class GenerateParenthesis {
    
    public static void main(String[] args) {
        int n = 3;
        List<String> ll = new ArrayList<>()
        Parenthesis(n, 0, 0, "");

    }

    public static void Parenthesis(int n, int closed, int open, String ans) {
       
        if(open == n && closed == n) {
            System.out.println(ans);
            return;
        }
        
      
        if(open > n || closed > open) {
            return;
        }
        
        
        if(open < n) {
            Parenthesis(n, closed, open + 1, ans + "(");
        }
        

        if(closed < open) {
            Parenthesis(n, closed + 1, open, ans + ")");
        }
    }
}
