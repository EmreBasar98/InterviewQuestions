public class BinTreeDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(3);
        binaryTree.right = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(7);
        binaryTree.left.right = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.left.left = new BinaryTree(9);
        binaryTree.left.right.right = new BinaryTree(5);
        binaryTree.left.right.right.right = new BinaryTree(6);
        binaryTree.left.right.right.right.right = new BinaryTree(11);

        System.out.println(binaryTreeDiameter(binaryTree));
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        int[] diameter = {0};
        helper(tree, diameter);
        return diameter[0];
    }

    public static int helper(BinaryTree tree, int[] diameter) {
        if (tree == null) {
            return 0;
        }
        int leftHeight = helper(tree.left, diameter);
        int rightHeight = helper(tree.right, diameter);
        if (leftHeight + rightHeight> diameter[0]) {
            diameter[0] = leftHeight + rightHeight;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
