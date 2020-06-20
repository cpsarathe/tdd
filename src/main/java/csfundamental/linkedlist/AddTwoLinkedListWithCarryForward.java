package csfundamental.linkedlist;

public class AddTwoLinkedListWithCarryForward {
    public static void main(String[] ar) {
        ListNode head = new ListNode(2);
        RemoveDuplicatesFromLinkedList.addItem(head, 4);
        RemoveDuplicatesFromLinkedList.addItem(head, 3);
        RemoveDuplicatesFromLinkedList.printItem(head);
        System.out.println("*********************");
        ListNode head2 = new ListNode(5);
        RemoveDuplicatesFromLinkedList.addItem(head2, 6);
        RemoveDuplicatesFromLinkedList.addItem(head2, 4);
        RemoveDuplicatesFromLinkedList.addItem(head2, 7);
        RemoveDuplicatesFromLinkedList.printItem(head2);
        System.out.println("*********************");
        ListNode resultNode = addLists(head, head2, 0);
        RemoveDuplicatesFromLinkedList.printItem(resultNode);

    }

    // when both linked list of same size
    public static ListNode addTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode resultNodeHead = null;
        ListNode resultNodeTop = null;
        ListNode resultParent = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val;
            if (resultNodeHead == null) {
                ListNode resultNode = new ListNode(result);
                resultNodeHead = resultNode;
                if (resultNodeTop == null) {
                    resultNodeTop = resultNodeHead;
                    resultParent = resultNodeTop;
                } else {
                    resultNodeTop.next = resultNodeHead;
                    resultNodeTop = resultNodeTop.next;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
            resultNodeHead = resultNodeHead.next;
        }
        return resultParent;
    }

    //add two lst of different size and do carry forward in next node
    public static ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(carry);
        int value = carry;
        if (l1 != null) {
            value += l1.val;
        }
        if (l2 != null) {
            value += l2.val;
        }
        result.val = value % 10;
        ListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }
}
