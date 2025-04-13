import java.util.*;

public class treeques {

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	public treeques() {
	
		root = CreateTree();
	}

	Scanner sc = new Scanner(System.in);

	private Node CreateTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = CreateTree();
		}
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = CreateTree();
		}
		return nn;
	}

    public boolean find(int item){
        return find(root, item);
    }

    private boolean find(Node nn , int item){

        if(nn.val==item){
            return true;
        }
        boolean left = find(nn.left, item);
        boolean right = find(nn.right, item);
        return left || right;

        // return false;
    }
    public int max(){
        return max(root);
    }
    private int max(Node nn){
        if(nn==null){
            return Integer.MIN_VALUE;
        }
        int lmax = max(nn.left);
        int rmax = max(nn.right);
        int max = Math.max(lmax, rmax);
        return Math.max(max, nn.val);
    }

    //height of the tree

    public int ht(Node nn){
        if(nn==null){
            return 0;
        }
        int lht = ht(nn.left);
        int rht = ht(nn.right);
        return Math.max(lht, rht)+1;
    }
/// preorder
         
public void preorder(Node nn){
    if(nn==null){
        return;
    }
    System.out.print(nn.val+" ");
    preorder(nn.left);
    preorder(nn.right);
    
}

// inorder 

public void inorder(Node nn){
    if(nn==null){
        return;
    }
    inorder(nn.left);
    System.out.print(nn.val+" ");
   
    inorder(nn.right);
    
}

public void PostOrder(Node nn){
    if(nn==null){
        return;
    }
    PostOrder(nn.left);
    PostOrder(nn.right);
    System.out.print(nn.val+" ");


    //level order traversal 

    public void levelOrder(Node nn){

        Queue<Node> q = new LinkedList<>();
        q.add(nn);
        while(!q.isEmpty()){
            Node m = q.poll(); // remove the first element from the queue
            System.out.print(m.val+" ");
            if(n.left!=null){
                q.add(m.left);
            }
            if(n.right!=null){
                q.add(m.right);
            }
        }

        System.out.println("null");
    }

}

}