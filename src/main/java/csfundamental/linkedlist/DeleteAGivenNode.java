package csfundamental.linkedlist;

import java.util.List;

public class DeleteAGivenNode {
    public static void main(String[] ar) {
        ListNode head = new ListNode(10);
        ListNode node1 = RemoveDuplicatesFromLinkedList.addItem(head, 10);
//        ListNode node2 = RemoveDuplicatesFromLinkedList.addItem(head, 30);
//        ListNode node3 = RemoveDuplicatesFromLinkedList.addItem(head, 40);
//        ListNode node4 = RemoveDuplicatesFromLinkedList.addItem(head, 20);
//        ListNode node5 = RemoveDuplicatesFromLinkedList.addItem(head, 50);
//        RemoveDuplicatesFromLinkedList.printItem(head);
        System.out.println("*********************");
//        deleteAGivenNode(head, 20);
//        deleteAGivenNode(node2);
        RemoveDuplicatesFromLinkedList.printItem(head);

        System.out.println("*********************");
//        ListNode node = removeNthFromEnd(head, 2);
//        RemoveDuplicatesFromLinkedList.printItem(node);

        ListNode node = removeElements(head,20);
        RemoveDuplicatesFromLinkedList.printItem(node);

    }

    /**
     * check head's -> next == val , if yes point head.next = head.next.next
     * in short skipping the chain
     *
     * @param head
     * @param val
     */
    public static void deleteAGivenNode(ListNode head, int val) {
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    /**
     * check head's -> next == val , if yes point head.next = head.next.next
     * in short skipping the chain
     */
    public static void deleteAGivenNode(ListNode node) {
        if (node == null && node.next == null) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }


    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
     * take one pointer to n-l th node and another to n-l+2
     *
     * @param head
     * @param n
     * @return
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        ListNode aux = head;
        ListNode dummy2 = head;

        int length = 0;

        while (aux != null) {
            aux = aux.next;
            length++;
        }

        if (length == 1 && n == 1) {
            return null;
        }
        if (length == n) {
            head = head.next;
            return head;
        }

        int end = length - n;
        for (int i = 1; i < end; i++) {
            dummy = dummy.next;
        }

        int end2 = length - n + 2;
        for (int i = 1; i < end2; i++) {
            dummy2 = dummy2.next;
        }

        dummy.next = dummy2;
        return head;

    }

    /**
     * Maintain previous and current pointer and skip pointer when value match
     * Also maintained a dummy pointer sentinel and point it to head.
     *
     * https://leetcode.com/problems/remove-linked-list-elements/submissions/
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        int length = 0;
        while(temp!=null) {
            temp = temp.next;
            length++;
        }
        if(length==1 && head.val==val){
            return null;
        } else {
            temp = head;
            while(temp!=null) {
                if(temp.val == val) {
                    prev.next = temp.next;
                }
                    prev = temp;
                    temp = temp.next;
            }
        }
        return sentinel.next;
    }

}

