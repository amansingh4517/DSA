
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;  
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;  
    }
}

public class BinaryTree{
    TreeNode root;

    public void insert(int data){
        root = insertrec(data , root);

    }
    public TreeNode insertrec(int data , TreeNode root){

        if(root==null) root = new TreeNode(data);
        else if (data<root.val){
           root.left = insertrec(data , root.left);
        }
        else root.right = insertrec(data , root.right);

        return root;
    }

    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

}