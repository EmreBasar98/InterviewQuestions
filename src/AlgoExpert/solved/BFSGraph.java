package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class BFSGraph {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");
        Node nodeK = new Node("K");

        nodeA.children.add(nodeB);
        nodeA.children.add(nodeC);
        nodeA.children.add(nodeD);

        nodeB.children.add(nodeE);
        nodeB.children.add(nodeF);

        nodeD.children.add(nodeG);
        nodeD.children.add(nodeH);

        nodeF.children.add(nodeI);
        nodeF.children.add(nodeJ);

        nodeG.children.add(nodeK);

        List<Node> nodeList = new ArrayList<>();

        nodeList.add(nodeA);
        nodeList.add(nodeB);
        nodeList.add(nodeC);
        nodeList.add(nodeD);
        nodeList.add(nodeE);
        nodeList.add(nodeF);
        nodeList.add(nodeG);
        nodeList.add(nodeH);
        nodeList.add(nodeI);
        nodeList.add(nodeJ);
        nodeList.add(nodeK);

        System.out.println(nodeList.get(0).breadthFirstSearch(new ArrayList<>()));
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            List<Node> q = new ArrayList<>();
            Node curr;
            q.add(this);
            while (!q.isEmpty()) {
                curr = q.get(0);q.remove(curr);
                array.add(curr.name);
                q.addAll(curr.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
