package csfundamental.linkedlist;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] ar) {
        ListNode head = new ListNode(10);
        addItem(head, 20);
        addItem(head, 30);
        addItem(head, 40);
        addItem(head, 10);
        printItem(head);
        System.out.println("*************************************");
        deleteDuplicates(head);
        printItem(head);

    }

    public static ListNode addItem(ListNode head, int val) {
        while (head.next != null) {
            head = head.next;
        }
        ListNode newNode = new ListNode(val);
        head.next = newNode;
        return  newNode;
    }

    public static void printItem(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    /**
     * O(N^2) as list is being traversed twice to check duplicates.
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode top = head;
        ListNode previous = head;
        ListNode current = previous.next;

        while (current != null) {
            ListNode runner = head;
            while (runner != current) {
                if (runner.val == current.val) {
                    ListNode temp = current.next;
                    previous.next = temp;
                    current = temp;
                    break;
                }
                runner = runner.next;
            }
            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
        return top;
    }
}

