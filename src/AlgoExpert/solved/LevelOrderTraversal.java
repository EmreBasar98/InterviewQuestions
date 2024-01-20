package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static List<List<Integer>> levelOrder(BinaryTree tree) {
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(tree);
        List<List<Integer>> returnArray = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelArray = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTree polled = q.poll();
                if (polled != null) {
                    levelArray.add(polled.value);
                    if (polled.left != null) q.add(polled.left);
                    if (polled.right != null) q.add(polled.right);
                }

            }
            if (!levelArray.isEmpty()) returnArray.add(levelArray);
        }
        return returnArray;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println(levelOrder(root));
    }
}

