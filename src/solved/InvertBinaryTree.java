
public class InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);
        binaryTree.left.right = new BinaryTree(5);

        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);

        invertBinaryTree(binaryTree);
        print(binaryTree);
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) return;
        if (tree.left != null) invertBinaryTree(tree.left);
        if (tree.right != null) invertBinaryTree(tree.right);
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    public static void print(BinaryTree tree) {
        if (tree == null) return;
        else {
            System.out.println(tree.value);
            print(tree.left);
            print(tree.right);
        }
    }


    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
