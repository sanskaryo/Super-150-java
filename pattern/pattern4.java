

public class pattern4 {

    public static void main(String[] args) {

            int n =5;
            int star =1;
            int space = n-1;
            int row = 1;
            while(row<=n){
                int i=1;
                while(i<=space){
                    System.out.print("  ");
                    i++;
                }
                int j =1;
                while(j<=star){
                    System.out.print("* ");
                    j++;
                }
                System.out.println();
                row++;
                space--;
                star+=2;
            }




        // int n = 5;

        // int row = 1;
        // int star =1;
        // int space = n-1;
        // while(row<=n){
        //     //space
        //     int i=1;
        //     while(i<=space){
        //         System.out.print(" ");
        //         i++;
        //     }
        //     //star
        //     int j =1;
        //     while(j<=star){
        //         System.out.print("* ");
        //         j++;
        //     }
        //     //nxt row
        //     row++;
        //     System.out.println();
        //     space--;
        //     star++;
        }
    }
    

