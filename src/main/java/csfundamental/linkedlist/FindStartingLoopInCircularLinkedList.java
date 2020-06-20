package csfundamental.linkedlist;

import java.util.HashSet;

public class FindStartingLoopInCircularLinkedList {

    public static void main(String[] ar) {
        ListNode head = new ListNode(10);
        ListNode node1 = RemoveDuplicatesFromLinkedList.addItem(head, 20);
        ListNode node2 = RemoveDuplicatesFromLinkedList.addItem(head, 30);
        ListNode node3 = RemoveDuplicatesFromLinkedList.addItem(head, 40);
        node3.next = node1; //circular list
       // RemoveDuplicatesFromLinkedList.printItem(head);
        System.out.println("*********************");
//        ListNode loopedNode = findStartingLoopInCircularLinkedListByMap(head);
//        if(loopedNode!=null) {
//            System.out.println(loopedNode.val);
//        }

        ListNode loopedNode = findStartingLoopInCircularLinkedList(head);
        if(loopedNode!=null) {
            System.out.println(loopedNode.val);
        }

    }

    //using hashMap
    public static ListNode findStartingLoopInCircularLinkedListByMap(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode findStartingLoopInCircularLinkedList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                break;
            }
        }
        p1 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
