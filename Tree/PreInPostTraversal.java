
public class PreInPostTraversal {
    private static void PrePrint(TreeNode root){
        if(root==null) return ;
        System.out.print(root.val + " ");
        PrePrint(root.left);
        PrePrint(root.right);
    }
    private static void InPrint(TreeNode root){
        if(root==null) return ;
        InPrint(root.left);
        System.out.print(root.val + " ");
        InPrint(root.right);
    }

    private static void PostPrint(TreeNode root){
        if(root==null) return ;
        PostPrint(root.left);
        PostPrint(root.right);
        System.out.print(root.val + " ");
    }
     
    public static void main(String[] args){
        PrePrint(root);
        InPrint(root);
        PostPrint(root);
    }
    
}
