public class BinTreeSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2); binaryTree.left.parent = binaryTree;
        binaryTree.right = new BinaryTree(3); binaryTree.right.parent = binaryTree;
        binaryTree.right.left = new BinaryTree(8);binaryTree.right.left.parent= binaryTree.right;
        binaryTree.right.left.left = new BinaryTree(13);binaryTree.right.left.left.parent= binaryTree.right.left;
        binaryTree.right.left.right = new BinaryTree(10);binaryTree.right.left.right.parent= binaryTree.right.left;
        binaryTree.right.right = new BinaryTree(9);binaryTree.right.right.parent= binaryTree.right;
        binaryTree.right.right.left = new BinaryTree(11);binaryTree.right.right.left.parent= binaryTree.right.right;
        binaryTree.left.left = new BinaryTree(4); binaryTree.left.left.parent = binaryTree.left;
        binaryTree.left.right = new BinaryTree(5); binaryTree.left.right.parent = binaryTree.left;
        binaryTree.left.right.right = new BinaryTree(12); binaryTree.left.right.right.parent = binaryTree.left.right;
        binaryTree.left.left.left = new BinaryTree(6); binaryTree.left.left.left.parent = binaryTree.left.left;
        binaryTree.left.right.left = new BinaryTree(7); binaryTree.left.right.left.parent = binaryTree.left.right;

        BinaryTree target = findSuccessor(binaryTree, new BinaryTree(1));

        if (target == null) {
            System.out.println("null");
        } else
            System.out.println(target.value);
    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        BinaryTree target = findNode(tree, node);

        if (target.right != null) {
            if (target.parent == null)return null;
            return findSuccessorHelper(target.right);
        } else {
            if (target.parent.left != null && target.value == target.parent.left.value) {
                return target.parent;
            }
            if (target.parent.right!= null && target.value == target.parent.right.value) {
                BinaryTree prevTarget = target;
                while (target.parent != null) {
                    prevTarget = target;
                    target = target.parent;
                }
                if (target.left == prevTarget)return target;
                else return null;
            }
        }
        return null;
    }

    public static BinaryTree findSuccessorHelper(BinaryTree tree) {
        if (tree.left != null) return findSuccessorHelper(tree.left);
        else return tree;
    }
    public static BinaryTree findNode(BinaryTree tree, BinaryTree node) {
        if ( tree == null || tree.value == node.value ) {
            return tree;
        }
        BinaryTree target = findNode( tree.left, node);

        if (target == null){
            target = findNode(tree.right, node);
        }
        return target;
    }
}
