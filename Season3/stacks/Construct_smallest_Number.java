import java.util.*;

public class Construct_smallest_Number {

    public static void main(String[] args) {
        String str = "IIIDIDDD";
    }

    public static String Construct(String str) {
		int[] ans = new int[str.length() + 1];
		Stack<Integer> st = new Stack<>();
		int count = 1;
		for (int i = 0; i <= str.length(); i++) {
			if (i == str.length() || str.charAt(i) == 'I') {
				ans[i] = count;
				count++;
				while (!st.isEmpty()) {
					ans[st.pop()] = count;
					count++;
				}
			}

			else {
				st.push(i);
			}
		}
		String s = "";
		for (int i = 0; i < ans.length; i++) {
			s = s + ans[i];
		}
		return s;
	}
}