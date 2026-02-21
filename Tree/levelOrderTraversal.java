import java.util.Queue;
import java.util.LinkedList;

public class levelOrderTraversal {
    public static void LOT(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            TreeNode front = q.remove();
            System.out.print(front.val + " ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
                }
        }
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        int[] arr = {6,4,3,2,7,5,9};
        for(int i =0 ; i < arr.length ; i++){
            tree.insert(arr[i]);
        }
        tree.inorder();
    }
}
