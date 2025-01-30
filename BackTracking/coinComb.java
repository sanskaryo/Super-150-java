


import java.util.*;
import java.util.List;
import javax.swing.event.AncestorEvent;

public class coinComb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin= {2,3,6,7};  
		int amount=7;
        List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ll=new ArrayList<>();
		Combination(coin,amount,ll,0,ans);
	}
	public static void Combination(int[] coin,int amount,List<Integer> ll,int idx,List<List<Integer>> ans) {
		if(amount ==0) {
			ans.add(new ArrayList<>(ll));
			return;
		}
		for(int i=idx;i<coin.length;i++) {
			if(amount>=coin[i]) {
				ll.add(coin[i]);
				Combination(coin,amount-coin[i],ll,i,ans);
                ll.remove(ll.size() - 1);
			}
		}
	}

}