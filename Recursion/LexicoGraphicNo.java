public class LexicoGraphicNo {

    public static void main(String[] args) {
        int n =1000;
        Print(n,0);
        
    }

    public static void Print(int n , int curr) {
        if(curr>n){
            return;
        }
        System.out.println(curr);
        int i=0;
        if(curr==0){
            i=1;
            
        }
        for(;i<=9;i++){
            Print(n,curr*10+i);
        }  
    }
}




