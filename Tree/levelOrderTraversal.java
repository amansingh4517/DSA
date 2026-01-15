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

    }
}
