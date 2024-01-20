package AlgoExpert.solved;

public class DeleteNodesGraterThanX {
    public static void main(String[] args) {
        SinglyLinkedListNode listHead = new SinglyLinkedListNode(5, new SinglyLinkedListNode(5, new SinglyLinkedListNode(2, new SinglyLinkedListNode(1, new SinglyLinkedListNode(6, new SinglyLinkedListNode(7, new SinglyLinkedListNode(5)))))));
        printList(removeNodes(listHead,3));
    }

    public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {
        SinglyLinkedListNode tempCurrent = listHead;
        while (tempCurrent != null) {
            if(tempCurrent.data > x) {
                listHead = tempCurrent.next;
            }
            if (tempCurrent.next != null && tempCurrent.next.data > x){
                tempCurrent.next = tempCurrent.next.next;
            }
            else {
                tempCurrent = tempCurrent.next;
            }
        }
        return listHead;
    }

    public static void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }
}

