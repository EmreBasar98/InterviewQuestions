public class EvalExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(-1);
        binaryTree.left = new BinaryTree(-4);
        binaryTree.right = new BinaryTree(-3);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(2);
        binaryTree.right.left = new BinaryTree(4);
        binaryTree.right.right = new BinaryTree(-4);
        binaryTree.right.right.left = new BinaryTree(1);
        binaryTree.right.right.right = new BinaryTree(2);
//        binaryTree.left.left.left = new BinaryTree(2);
//        binaryTree.left.left.right = new BinaryTree(3);



        System.out.println(evaluateExpressionTree(binaryTree));
    }

    public static int evaluateExpressionTree(BinaryTree tree) {

        if (tree.value > 0){
            return tree.value;
        }
        int leftEval = evaluateExpressionTree(tree.left);
        int rightEval = evaluateExpressionTree(tree.right);

        return doOp(leftEval, rightEval, tree.value);
    }

    public static int doOp(int left, int right, int op) {
        return switch (op) {
            case -1 -> left + right;
            case -2 -> left - right;
            case -3 -> left / right;
            case -4 -> left * right;
            default -> -1;
        };
    }
}
