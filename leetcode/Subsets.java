import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		SubsetPrint(arr, 0, list, ans);
		System.out.println(ans);
	}

	public static void SubsetPrint(int[] arr, int i, List<Integer> list, List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<>(list));
			return;
		}

		
		SubsetPrint(arr, i + 1, list, ans);
		
	
		list.add(arr[i]);
		SubsetPrint(arr, i + 1, list, ans);
		list.remove(list.size() - 1);
	}

}