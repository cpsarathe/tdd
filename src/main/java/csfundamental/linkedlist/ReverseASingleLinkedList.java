package csfundamental.linkedlist;

public class ReverseASingleLinkedList {
    public static void main(String[] ar) {
        ListNode head = new ListNode(2);
        RemoveDuplicatesFromLinkedList.addItem(head, 4);
        RemoveDuplicatesFromLinkedList.addItem(head, 3);
        RemoveDuplicatesFromLinkedList.printItem(head);
        System.out.println("*********************");
        ListNode node = reverseLinkedList(head);
        RemoveDuplicatesFromLinkedList.printItem(node);
    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

}
