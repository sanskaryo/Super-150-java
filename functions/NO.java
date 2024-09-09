import java.util.Scanner;  

public class NO {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  

         
        int n1 = scanner.nextInt();  
   
        int n2 = scanner.nextInt();  

        
        for (int i = n1; i <= n2; i++) {  
            if (isArmstrong(i)) {  
                System.out.println(i);  
            }  
        }  

        scanner.close();  
    }  


    public static boolean isArmstrong(int number) {  
        int sum = 0, temp, digits = 0;  

        temp = number;  
         
        while (temp != 0) {  
            digits++;  
            temp /= 10;  
        }  

        temp = number;  
     
        while (temp != 0) {  
            int digit = temp % 10;  
            sum += Math.pow(digit, digits);  
            temp /= 10;  
        }  
 
        return (sum == number);  
    }  
}