
public class SymmetricalTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean symmetricalTree(BinaryTree tree) {
        if (tree == null) return false;
        if (tree.left == null && tree.right == null) return true;
        if (tree.left == null || tree.right == null) return false;
        return tree.left.value == tree.right.value
                && helper(tree.left.left, tree.right.right)
                && helper(tree.left.right, tree.right.left);
    }

    public static boolean helper(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.value == tree2.value
                && helper(tree1.left, tree2.right)
                && helper(tree1.right, tree2.left);
    }
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println(symmetricalTree(root));
    }


}
