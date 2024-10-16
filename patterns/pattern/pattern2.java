package pattern;

public class pattern2 {
    

        public static void main(String[] args) {
            int n=5;
    
            int star = n;
            int row =1;
            while(row<=n){
                int i=1;
                while(i<=star){
                    System.out.print("* ");
                    i++;
                }
                System.out.println();
                row++;
            }
    
        }
    
    
    
}
