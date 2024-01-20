package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SplitBinaryTree {
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree(1);
        t1.left = new BinaryTree(2);
        t1.right = new BinaryTree(1);
        t1.right.right = new BinaryTree(1);

        System.out.println(splitBinaryTree(t1));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static int splitBinaryTree(BinaryTree tree) {
        int treeSum = calculateSum(tree);
        if (treeSum % 2 == 1) return 0;
        if (findSplitting(tree, treeSum) == treeSum / 2) return treeSum / 2;
        else return 0;
    }

    public static int calculateSum(BinaryTree tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return tree.value;
        int leftSum = calculateSum(tree.left);
        int rightSum = calculateSum(tree.right);
        return tree.value + leftSum + rightSum;
    }

    public static int findSplitting(BinaryTree tree, int totalSum) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return tree.value;
        int leftSum = findSplitting(tree.left, totalSum);
        int rightSum = findSplitting(tree.right, totalSum);
        if (leftSum == (totalSum / 2)) return leftSum;
        else if (rightSum == (totalSum / 2)) return rightSum;
        return tree.value + leftSum + rightSum;
    }
}

