package ongoing;

public class BSTConstruction {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        System.out.println(bst.remove(10));

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
            if (this.value == value) {
                if (this.left != null && this.right == null) {
                    this.value = this.left.value;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if (this.right != null && this.left == null) {
                    this.value = this.right.value;
                    this.left = this.right.left;
                    this.right = this.right.right;
                } else if (this.left != null) {
                    System.out.println(this.findNDeleteReplacement());
                }
            } else {
                if (this.left.value == value) {

                } else if (this.right.value == value) {

                } else {
                    if (this.value < value) {
                        this.right.remove(value);
                    } else {
                        this.left.remove(value);
                    }
                }
            }
            return this;
        }

        private int findNDeleteReplacement() {
            System.out.println("asdasd");
            BST temp = this.right;
            if (temp.left == null) {
                this.right = temp.right;
            }
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp.value;
        }
    }

}
