import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        int leftPointer = 0;
        int rightPointer = 1;

        while (preOrderTraversalValues.get(leftPointer) > preOrderTraversalValues.get(rightPointer)) {
            rightPointer++;
        }

        return null;
    }

    public BST helper(ArrayList<Integer> preOrderTraversalValues, int index, BST node) {

        return null;
    }

    public static void main(String[] args) {
        reconstructBst(new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18)));
    }
}
