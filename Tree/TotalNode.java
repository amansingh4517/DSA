public class TotalNode {
    static class TreeNode {
        int val;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    static class BST{
        TreeNode root;

        private TreeNode insert(int val , TreeNode node){
            if(node == null) return new TreeNode(val);
            else if(val < node.val) node.left = insert(val , node.left);
            else node.right = insert(val , node.right); 
            return node;
        }

        public TreeNode insert(int val){
            return this.root = insert(val , this.root);  
        }

        public TreeNode createBST(int[] arr){
            this.root = null;
            for(int val : arr){
                insert(val);
            }
            return this.root;
        }
    }

    private static int count(TreeNode root){
        if(root == null ) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    
    public static void main(String[] args) {
        int[] arr = {5,4,2,6,8,1,3,9,7,0};
        BST bst = new BST();
        TreeNode root = bst.createBST(arr);
        System.out.println(count(root));
        
    }
    
}
