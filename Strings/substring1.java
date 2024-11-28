
public class substring1 {

    public static void main(String[] args) {

        String s = "Hello";
        // String subStr = s.substring(7, 12);
        // System.out.println(subStr);

        printsubstring(s);

       



    }

    public static void printsubstring(String s) {

        // int count =0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                System.out.println(subStr);
                // count++;
        
    }
}
    }
    
}
