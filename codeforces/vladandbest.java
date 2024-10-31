import java.util.Scanner;

public class vladandbest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        
        while (t-- > 0) {
            String input = sc.nextLine();
            char result = getMostFreq(input);
            System.out.println(result);
        }
        
        sc.close();
    }
    
    public static char getMostFreq(String input) {
        int countA = 0;
        int countB = 0;

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                countA++;
            } else if (c == 'B') {
                countB++;
            }
        }
        return countA >= countB ? 'A' : 'B';
    }
}