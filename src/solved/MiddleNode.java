public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }

    public static LinkedList middleNode(LinkedList linkedList) {
        if (linkedList.next == null) return linkedList;
        LinkedList pointerOne = linkedList;
        LinkedList pointerTwo = linkedList;
        while (pointerTwo != null) {
            pointerTwo = pointerTwo.next;
            if (pointerTwo != null) pointerTwo = pointerTwo.next;
            else break;
            pointerOne = pointerOne.next;
        }
        return pointerOne;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, null))));

        System.out.println(middleNode(head).value);
    }
}
