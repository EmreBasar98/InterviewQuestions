public class ValidateThreeNodes {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BST root = new BST(3);
        root.left = new BST(2);
        root.left.left = new BST(1);
        System.out.println(validateThreeNodes(root.left.left, root.left, root));
    }


    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST nodeTwoSearchOne = findAndReturn(nodeOne, nodeTwo); // O(n)
        BST nodeTwoSearchThree = findAndReturn(nodeThree, nodeTwo); // O(n)
        if (nodeTwoSearchOne == null && nodeTwoSearchThree == null) {
            return false;
        }
        if (nodeTwoSearchOne != null) {
            BST nodeThreeSearch = findAndReturn(nodeTwoSearchOne, nodeThree); // O(n)
            if (nodeThreeSearch != null) {
                return true;
            }
        }
        if (nodeTwoSearchThree != null) {
            BST nodeOneSearch = findAndReturn(nodeTwoSearchThree, nodeOne); // O(n)
            return nodeOneSearch != null;
        }
        return false;
    }


    public static BST findAndReturn(BST node, BST target) {
        if (node == null) {
            return null;
        }
        if (node.value == target.value) {
            return node;
        }
        if (node.value > target.value) {
            return findAndReturn(node.left, target);
        } else {
            return findAndReturn(node.right, target);
        }
    }
}
