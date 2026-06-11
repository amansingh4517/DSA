public class Depth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BST {
        TreeNode root;

        public TreeNode insert(int val, TreeNode node) {
            // we are not using root because we are inserting node at any part of tree not at first node
            if (node == null)
                return new TreeNode(val);
            else if (val < node.val)
                node.left = insert(val, node.left);
            else 
                node.right = insert(val, node.right);
            return node;
        }

        // we have to create from base or add node to a tree so need it base root here thats why using this.root
        public void insert(int val) {
            this.root = insert(val, this.root);
        }

        public TreeNode createTree(int[] arr) {
            this.root = null;
            for (int val : arr) {
                this.root = insert(val, this.root);
            }
            return root;
        }

        public void inorderPrint(TreeNode root){
            if(root == null) return ;
            inorderPrint(root.left);
            System.out.print(root.val + " ");
            inorderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,3,5,7,6,2,9,0,8};
        BST bst = new BST();
        TreeNode root = bst.createTree(arr);
        bst.inorderPrint(root);
    }
}
