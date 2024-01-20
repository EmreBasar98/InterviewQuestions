package AlgoExpert.solved;

public class SumOfLinkedLists {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
        linkedListOne.next = new LinkedList(4);
        linkedListOne.next.next = new LinkedList(7);
        linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
        linkedListTwo.next = new LinkedList(4);
        linkedListTwo.next.next = new LinkedList(5);

        LinkedList result = sumOfLinkedLists(linkedListOne, linkedListTwo);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList headFirst = linkedListOne;
        LinkedList headSecond = linkedListTwo;
        boolean remainder = false;
        LinkedList resultHead = new LinkedList(0);
        LinkedList resultIter = resultHead;
        while (headFirst != null || headSecond != null) {
            int sumOfNodes = 0;
            if (remainder) {
                sumOfNodes ++;
                remainder = false;
            }
            if (headFirst != null && headSecond != null) {
                sumOfNodes += headFirst.value + headSecond.value;
                if (sumOfNodes >= 10) {
                    remainder = true;
                    sumOfNodes = sumOfNodes % 10;
                }
            } else if (headFirst == null) {
                sumOfNodes += headSecond.value;
                if (sumOfNodes >= 10) {
                    remainder = true;
                    sumOfNodes = sumOfNodes % 10;
                }
            } else if (headSecond == null) {
                sumOfNodes += headFirst.value;
                if (sumOfNodes >= 10) {
                    remainder = true;
                    sumOfNodes = sumOfNodes % 10;
                }
            }

            resultIter.value = sumOfNodes;

            if (headFirst != null) headFirst = headFirst.next;
            if (headSecond != null) headSecond = headSecond.next;
            if (headFirst == null && headSecond == null) {
                if (remainder) resultIter.next = new LinkedList(1);
                else resultIter.next = null;
            } else {
                resultIter.next = new LinkedList(0);
                resultIter = resultIter.next;
            }
        }
        return resultHead;
    }
}
