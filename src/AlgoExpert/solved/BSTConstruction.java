package AlgoExpert.solved;

public class BSTConstruction {
    public static void main(String[] args) {
        BST bst = new BST(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
//        bst.insert(2);
//        bst.insert(5);
//        bst.insert(13);
//        bst.insert(22);
//        bst.insert(1);
//        bst.insert(14);
//        bst.insert(12);
        bst.preOrder();

        bst.remove(1);

        System.out.println();
        bst.preOrder();
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left = this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right = this.right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (this.value == value) return true;
            boolean leftContains = value < this.value && this.left != null && this.left.contains(value);
            boolean rightContains = value > this.value && this.right != null && this.right.contains(value);
            return leftContains || rightContains;
        }

        public BST remove(int value) {
            if (value < this.value) {
                this.left =  this.left.remove(value);
            } else if (value > this.value) {
                this.right = this.right.remove(value);
            } else {
                if (this.left == null && this.right == null) {
                    return null;
                }
                if (this.left == null) {
                    this.value = this.right.value;
                    this.right = this.right.right;
                    return this;
                } else if (this.right == null) {
                    this.value = this.left.value;
                    this.left = this.left.left;
                    return this;
                }

                this.value = findMin(this.right);
                this.right = this.right.remove(this.value);
            }
            return this;
        }


        private static int findMin(BST node) {
            while (node.left != null) {
                node = node.left;
            }
            return node.value;
        }


        private void preOrder() {
            System.out.printf("%s ", this.value);
            if (this.left != null) this.left.preOrder();
            if (this.right != null) this.right.preOrder();
        }
    }

}
