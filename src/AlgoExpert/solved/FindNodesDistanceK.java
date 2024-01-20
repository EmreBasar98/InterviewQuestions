package AlgoExpert.solved;

import java.util.*;

public class FindNodesDistanceK {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        if (k == 0) return new ArrayList<>(List.of(tree.value));
        HashMap<BinaryTree, BinaryTree> parentMap = new HashMap<>();
        createParentMap(tree, parentMap);
        BinaryTree targetNode = findTarget(tree, target);
        ArrayList<Integer> nodesList = new ArrayList<>();
        helper(targetNode, k, nodesList, parentMap, new HashSet<>());
        return nodesList;
    }

    public static BinaryTree findTarget(BinaryTree tree, int target) {
        if (tree == null) return null;
        if (tree.value == target) return tree;
        else if (tree.left == null && tree.right == null)return null;
        else if (tree.left != null) {
            BinaryTree left = findTarget(tree.left, target);
            if (left != null) return left;
        }
        return findTarget(tree.right, target);
    }

    public static void createParentMap(BinaryTree tree, HashMap<BinaryTree, BinaryTree> parentMap) {
        if (tree == null) return;
        if (tree.left != null) parentMap.put(tree.left, tree);
        if (tree.right != null) parentMap.put(tree.right, tree);
        createParentMap(tree.left, parentMap);
        createParentMap(tree.right, parentMap);
    }

    public static void helper(BinaryTree node, int k, ArrayList<Integer> nodesList, HashMap<BinaryTree, BinaryTree> parentMap, HashSet<BinaryTree> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        if (node == null) return;
        if (k<0) return;
        if (k == 0) nodesList.add(node.value);
        helper(node.left, k - 1, nodesList, parentMap, visited);
        helper(node.right, k - 1, nodesList, parentMap, visited);
        helper(parentMap.get(node), k -1 , nodesList, parentMap, visited);
    }


    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree(1);
        t1.left = new BinaryTree(2);
        t1.right = new BinaryTree(3);
        t1.left.left = new BinaryTree(4);
        t1.left.right = new BinaryTree(5);
        t1.right.right = new BinaryTree(6);
        t1.right.right.left = new BinaryTree(7);
        t1.right.right.right = new BinaryTree(8);

        System.out.println(findNodesDistanceK(t1, 3, 2));
    }
}
