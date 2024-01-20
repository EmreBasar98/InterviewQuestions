package AlgoExpert.solved;

public class RemoveKthNodeFromEnd {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next = new LinkedList(7);
        linkedList.next.next.next.next.next.next.next = new LinkedList(8);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(9);

        removeKthNodeFromEnd(linkedList, 1);

        while (linkedList != null) {
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }


    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        if (head == null) return;
        LinkedList firstPointer = head;
        LinkedList secondPointer = head;

        for (int i = 0; i < k; i++) {
            secondPointer = secondPointer.next;
        }

        if (secondPointer == null) {
            removeHead(head);
            return;
        }

        while (secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        removeNode(firstPointer);
    }

    public static void removeHead(LinkedList head) {
        head.value = head.next.value;
        head.next = head.next.next;
    }

    public static void removeNode(LinkedList prevNode) {
        prevNode.next = prevNode.next.next;
    }


    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
