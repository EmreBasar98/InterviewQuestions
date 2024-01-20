package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSumInBinaryTree {
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree(1);
        t1.left = new BinaryTree(2);
        t1.right = new BinaryTree(-1);
//        t1.left = new BinaryTree(2);
//        t1.right = new BinaryTree(3);
//        t1.left.left = new BinaryTree(4);
//        t1.left.right = new BinaryTree(5);
//        t1.right.left = new BinaryTree(6);
//        t1.right.right = new BinaryTree(7);


        System.out.println(maxPathSum(t1));
    }

    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSums = new ArrayList<>();
        helper(tree, maxSums);
        int max = maxSums.get(0);
        for(int sum : maxSums){
            if(sum > max) max = sum;
        }
        return max;
    }

    public static int helper(BinaryTree tree, List<Integer> maxSums) {
        if(tree == null) return 0;
        int leftSum =helper(tree.left, maxSums);
        int rightSum = helper(tree.right, maxSums);
        int subPathSum = Math.max(Math.max(leftSum, rightSum) + tree.value, tree.value);
        int candidatePathSum = leftSum + rightSum + tree.value;
        int candidatePathLeftSum = leftSum + tree.value;
        int candidatePathRightSum = rightSum + tree.value;
        int candidatePathMax = Math.max(Math.max(candidatePathLeftSum, candidatePathRightSum), candidatePathSum);
        maxSums.add(candidatePathSum);
        maxSums.add(candidatePathMax);
        return subPathSum;
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
