public class RepairBst {

    BST prev = null;
    BST first = null;
    BST second = null;
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(7);
        tree.left.left = new BST(3);
        tree.left.right = new BST(12);

        tree.right = new BST(20);
        tree.right.left = new BST(8);
        tree.right.right = new BST(22);

        BST repaired = new RepairBst().repairBst(tree);
        System.out.println(repaired);
    }
    public BST repairBst(BST tree) {
        inorder(tree);
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
        return tree;
    }

    public void inorder(BST tree) {
        if (tree == null) return;
        inorder(tree.left);
        if (prev != null && prev.value > tree.value) {
            if (first == null) {
                first = prev;
            }
            second = tree;
        }
        prev = tree;
        inorder(tree.right);
    }
}
