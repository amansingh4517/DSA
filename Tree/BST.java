    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class BST {
        TreeNode root;

        public TreeNode insert(int val, TreeNode node) {
            // we are not using root because we are inserting node at any part of tree not at first node
            if (node == null)
                return new TreeNode(val);
            else if (val < root.val)
                root.left = insert(val, root.left);
            else if (val > root.val)
                root.right = insert(val, root.right);
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
    }