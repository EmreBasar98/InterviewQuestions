import java.util.HashSet;
import java.util.Set;

public class YoungestCommonAncestor {

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }


    public static AncestralTree getYoungestCommonAncestorSol1(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        if (descendantOne.ancestor == descendantTwo ) return descendantTwo;
        if (descendantTwo.ancestor == descendantOne ) return descendantOne;
        if (descendantOne == topAncestor ) return descendantOne;
        if (descendantTwo == topAncestor ) return descendantTwo;
        Set<AncestralTree> visitedNodes = new HashSet<>();
        AncestralTree ancestorOne = descendantOne.ancestor;
        AncestralTree ancestorTwo = descendantTwo.ancestor;

        while (ancestorOne != topAncestor || ancestorTwo != topAncestor) {
            if (ancestorOne == descendantTwo) return  descendantTwo;
            if (ancestorTwo == descendantOne) return descendantOne;

            if (ancestorOne != topAncestor) {
                if (visitedNodes.contains(ancestorOne)) return ancestorOne;
                visitedNodes.add(ancestorOne);
                ancestorOne = ancestorOne.ancestor;
            }
            if (ancestorTwo != topAncestor) {
                if (visitedNodes.contains(ancestorTwo)) return ancestorTwo;
                visitedNodes.add(ancestorTwo);
                ancestorTwo = ancestorTwo.ancestor;
            }
        }

        return topAncestor;
    }

    public static AncestralTree getYoungestCommonAncestorSol2(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        if (descendantOne.ancestor == descendantTwo ) return descendantTwo;
        if (descendantTwo.ancestor == descendantOne ) return descendantOne;
        if (descendantOne == topAncestor ) return descendantOne;
        if (descendantTwo == topAncestor ) return descendantTwo;

        AncestralTree ancestorOne = descendantOne.ancestor;
        AncestralTree ancestorTwo = descendantTwo.ancestor;

        int depthOne = 0;
        int depthTwo = 0;

        while (ancestorOne != topAncestor) {
            depthOne ++;
            ancestorOne = ancestorOne.ancestor;
        }
        while (ancestorTwo != topAncestor) {
            depthTwo ++;
            ancestorTwo = ancestorTwo.ancestor;
        }

        AncestralTree deeperNode = depthOne > depthTwo ? descendantOne : descendantTwo;
        AncestralTree higherNode = depthOne > depthTwo ? descendantTwo : descendantOne;
        int biggerDepth = Math.max(depthOne, depthTwo);

        while (biggerDepth != Math.min(depthOne, depthTwo)) {
            if (deeperNode.ancestor == higherNode) return higherNode;
            deeperNode = deeperNode.ancestor;
            biggerDepth--;
        }

        ancestorOne = descendantOne.ancestor;
        ancestorTwo = descendantTwo.ancestor;

        while (ancestorOne != topAncestor || ancestorTwo != topAncestor) {
            if (ancestorOne.ancestor == ancestorTwo.ancestor) return ancestorOne.ancestor;
            ancestorOne = ancestorOne.ancestor;
            ancestorTwo = ancestorTwo.ancestor;
        }

        return topAncestor;
    }



    public static void main(String[] args) {

    }


}
