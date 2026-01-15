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

public class Structure{
    private static void PrePrint(TreeNode root){
        if(root==null) return ;
        System.out.print(root.val + " ");
        PrePrint(root.left);
        PrePrint(root.right);
    }

public static void main(String[] args){
    TreeNode a = new TreeNode(1);
    TreeNode b = new TreeNode(2);
    TreeNode c = new TreeNode(3);
    TreeNode d = new TreeNode(4);
    TreeNode e = new TreeNode(5);
    TreeNode f = new TreeNode(6);
    TreeNode g = new TreeNode(7);
    TreeNode h = new TreeNode(8);
    TreeNode i = new TreeNode(9);
    TreeNode j = new TreeNode(10);

    a.left = b ; a.right = c;
    b.left = d ; b.right = e;
    c.left = f ; c.right = g;
    d.left = h ; d.right = i;
    e.left = j;


    
    PrePrint(a);

}
}