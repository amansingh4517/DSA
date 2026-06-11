import java.util.Scanner;

public class SymmetryOfTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static class BST {
        Node root;

        private Node insert(int val, Node node) {
            if (node == null)
                return new Node(val);
            else if (val < node.val)
                node.left = insert(val, node.left);
            else
                node.right = insert(val, node.right);
            return node;
        }

        public Node insert(int val) {
            return this.root = insert(val, this.root);
        }

        public Node createBST(int[] arr) {
            this.root = null;
            for (int val : arr) {
                insert(val, this.root);
            }
            return this.root;
        }
        public void inorderPrint(Node root){
            if(root == null) return ;
            inorderPrint(root.left);
            System.out.print(root.val+" ");
            inorderPrint(root.right);
        }
    }

    //Symmetry of Tree 
    private static boolean symmetry(Node l , Node r){
        if(l == null && r == null) return true;
        if(l == null || r == null)  return false;
        return symmetry(l.right , r.left) && symmetry(l.left , r.right);
    }
    private static boolean isSymmetric(Node root){
        if(root == null) return true;
        return symmetry(root.left , root.right);
    }

 ;   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BST bst = new BST();
        Node root = null;
        System.out.print("Enter total number of nodes : ");
        int n = sc.nextInt();
        System.out.print("Enter val of nodes with spaces : ");
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            root = bst.insert(temp);
        }
        // BST bst2 = new BST();
        // int[] arr = {1,2,2,3,4,4,3};
        // Node symRoot = bst2.createBST(arr);
        // System.out.println(isSymmetric(symRoot));
        System.out.println(isSymmetric(root));

        sc.close();
    }
}
