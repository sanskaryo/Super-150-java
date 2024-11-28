public class freq_array {

    public static void main(String[] args) {
        
        String s = "qwertyuiopasdfghjklzxcvbnmqazwsxedcrfvtgbyhnujmikolpertyiuoiuytdrfghkjljhgdfhjhg";

        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            int idx = ch -'a';
            freq[idx]++;
        }
    }
    
}
