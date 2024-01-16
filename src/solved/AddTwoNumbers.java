public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    // 2 -> 4 -> 4
    // 9 -> 4 - -|

    // 2 -> 4 -> 4
    // 1 -> 1

    // 2 -> 4
    // 1 -> 9 -> 3

    // Approach 1
    // - convert both ll into integer
    // - sum them up
    // - convert the integer to ll
    // - tc : o(3n) -> o(n)  sc : O(n)

    // Approach 2
    // - Sum every digit individually, save the result in one of the nodes
    //      - if result is greater than 10, keep flag
    // - if there was rem from prev op, result = 1, otherwise = 0
    // - if l1.next is null return l2, if l2.next is null make l2.next == l1.next
    // if there was a rem add it to l2.next.val

//      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        boolean rem = false;
//        ListNode temp1 = l1;
//        ListNode temp2 = l2;
//        while (temp1 != null && temp2 != null) {
//            int sum = temp1.val + temp2.val;
//            int sumResult = rem ? 1 : 0;
//            sumResult += sum % 10;
//            temp2.val = sumResult;
//            rem = sum > 9;
//            if (temp1.next == null && temp2.next != null) {
//                if (rem) temp2.next.val++;
//                return l2;
//            }else if (temp2.next == null && temp1.next != null) {
//                if (rem) temp1.next.val++;
//                temp2.next = temp1.next;
//                return l2;
//            }
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//        }
//        return l2;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyIter = dummy;
        int carry = 0;
        int sum = 0;
        while (temp1 != null || temp2 != null) {
            sum = carry;
            if (temp1!=null) sum += temp1.val;
            if (temp2!=null) sum += temp2.val;
            dummyIter.next = new ListNode(sum%10);
            carry = sum > 9 ? 1 : 0;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
            dummyIter = dummyIter.next;
        }
        if (carry > 0) dummyIter.next = new ListNode(carry);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode resultLL = addTwoNumbers(l1, l2);
        printLL(resultLL);
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
