package AlgoExpert.solved;

import java.util.*;

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
        BST root = new BST(preOrderTraversalValues.get(0));
        BST curNode = root;
        BST newNode = null;
        Map<Integer, Queue<BST>> nodeMap = new HashMap<>();
        int iter = 0;
        nodeMap.put(root.value, new LinkedList<>(List.of(root)));
        while (iter < preOrderTraversalValues.size() - 1) {
            while (curNode.value > preOrderTraversalValues.get(iter + 1)) {
                newNode = new BST(preOrderTraversalValues.get(iter + 1));
                curNode.left = newNode;
                curNode = newNode;
                nodeMap.computeIfAbsent(curNode.value, k -> new LinkedList<>()).add(curNode);
                iter++;
                if (iter == preOrderTraversalValues.size() - 1) break;
            }
            if (iter == preOrderTraversalValues.size() - 1) break;
            int max = curNode.value;
            int bwIter = iter;
            int newNodeVal = preOrderTraversalValues.get(bwIter + 1);
            while (bwIter >= 0 && newNodeVal >= preOrderTraversalValues.get(bwIter)) {
                max = preOrderTraversalValues.get(bwIter) >= max ? preOrderTraversalValues.get(bwIter) : max;
                bwIter--;
            }
            newNode = new BST(newNodeVal);
            nodeMap.computeIfAbsent(newNodeVal, k -> new LinkedList<>()).add(newNode);
            nodeMap.get(max).poll().right = newNode;
            curNode = newNode;
            iter++;
        }
        return root;
    }

    static void printPreorder(BST node) {
        if (node == null)
            return;

        // Deal with the node
        System.out.print(node.value + " ");

        // Recur on left subtree
        printPreorder(node.left);

        // Recur on right subtree
        printPreorder(node.right);
    }
    public static void main(String[] args) {
        printPreorder(reconstructBst(new ArrayList<>(Arrays.asList(10 ,4 ,7 ,17 ,19 ,18 ,18 ,19))));
    }
}
