import java.util.*;
public class Mfal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while(m-->0){
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(fact(a)/(fact(a-b)*fact(b)));
        
        
}

}
public static long fact(int n){
    long fac =1;
    for(int i=n;i>=1;i--){
    fac*=i;
}
return fac;
}

}





// import java.util.*;  

// public class Main {  
//     public static void main(String args[]) {  
//         Scanner sc = new Scanner(System.in);  
//         int m = sc.nextInt();  
        
//         while(m > 0){  
//             int a = sc.nextInt();  
//             int b = sc.nextInt();  

//             System.out.print(fact(a) / (fact(a - b) * fact(b)) + " ");  
//             m--; // Decrease m to avoid an infinite loop  
//         }  
        
//         sc.close(); // Close the scanner to prevent resource leaks  
//     }  
    
//     public static long fact(int n) {  
//         long result = 1;  
//         for(int i = 2; i <= n; i++){  
//             result *= i;  
//         }  
//         return result;  
//     }  
// }