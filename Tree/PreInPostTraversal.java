
public class PreInPostTraversal {
    public void PrePrint(TreeNode root){
        if(root==null) return ;
        System.out.print(root.val + " ");
        PrePrint(root.left);
        PrePrint(root.right);
    }
    public void InPrint(TreeNode root){
        if(root==null) return ;
        InPrint(root.left);
        System.out.print(root.val + " ");
        InPrint(root.right);
    }

    public void PostPrint(TreeNode root){
        if(root==null) return ;
        PostPrint(root.left);
        PostPrint(root.right);
        System.out.print(root.val + " ");
    }
     
    
}
