package csfundamental.linkedlist;

public class NthToLastElementSingleLinkedList {

    public static void main(String[] ar) {
        ListNode head = new ListNode(10);
        RemoveDuplicatesFromLinkedList.addItem(head, 20);
        RemoveDuplicatesFromLinkedList.addItem(head, 30);
        RemoveDuplicatesFromLinkedList.addItem(head, 40);
        RemoveDuplicatesFromLinkedList.addItem(head, 10);
        RemoveDuplicatesFromLinkedList.printItem(head);
        ListNode nthNode = findNthElementFromEnd(head,3);
        System.out.println("*********************");
        RemoveDuplicatesFromLinkedList.printItem(nthNode);

    }

    public static ListNode findNthElementFromEnd(ListNode head, int n) {
        int totalElements = 0;
        ListNode top = head;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            totalElements++;
        }
        if (n > totalElements) {
            throw new IllegalArgumentException("Total elements are less than nth value");
        }
        int index = totalElements - n;
        node = head;
        while (index != 0) {
            node = node.next;
            index--;
        }
        top = node;
        return top;
    }
}

