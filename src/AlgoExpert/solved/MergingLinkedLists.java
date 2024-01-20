package AlgoExpert.solved;

public class MergingLinkedLists {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(1);
        linkedListOne.next = new LinkedList(2);
        linkedListOne.next.next = new LinkedList(3);
        linkedListOne.next.next.next = new LinkedList(4);

        LinkedList linkedListTwo = new LinkedList(5);
        linkedListTwo.next = new LinkedList(3);
        linkedListTwo.next.next = new LinkedList(4);


        LinkedList mergedLinkedList = mergingLinkedLists(linkedListOne, linkedListTwo);
        System.out.println(mergedLinkedList);
        while (mergedLinkedList != null) {
            System.out.println(mergedLinkedList.value);
            mergedLinkedList = mergedLinkedList.next;
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

    public static LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int lenFirst = 0;
        int lenSecond = 0;

        LinkedList headFirst = linkedListOne;
        LinkedList headSecond = linkedListTwo;

        //bunun için bir method yazılabilir, temiz kod göstergesi olur
        while (headFirst != null) {
            lenFirst++;
            headFirst = headFirst.next;
        }

        while (headSecond != null) {
            lenSecond++;
            headSecond = headSecond.next;
        }

        int biggerLen = Math.max(lenFirst, lenSecond);
        int smallerLen = Math.min(lenFirst, lenSecond);
        LinkedList biggerList = lenFirst > lenSecond ? linkedListOne : linkedListTwo;
        LinkedList smallerList = lenFirst > lenSecond ? linkedListTwo : linkedListOne;

        while (biggerLen > smallerLen) {
            biggerList = biggerList.next;
            biggerLen--;
        }

        LinkedList resultList = null;

        while (biggerList != null && smallerList != null) {

            if (biggerList.value == smallerList.value) {
                resultList = biggerList;
                break;
            };

            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }
        return resultList;
    }
}
