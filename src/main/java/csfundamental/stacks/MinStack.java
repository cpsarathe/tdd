package csfundamental.stacks;

public class MinStack {
    Node top = null;
    Node head = null;

    public MinStack() {

    }

    public void push(int x) {
        Node newNode = new Node(x);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop() {
        Node temp = top;
        if (top != null) {
            top = top.next;
        }
    }

    public int top() {
        if (top != null) {
            return top.item;
        }
        return -1;

    }

    public int getMin() {
        head = top;
        int min = head.item;
        if(head.next==null){
            return head.item;
        }
        while (head != null) {
            int val = head.item;
            if (val < min) {
                min = val;
            }
            head = head.next;
        }
        return min;
    }

    public static void main(String[] ar) {
        MinStack minStack = new MinStack();
        //Test case 1 Passed
/*        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());*/

        //Test case 2 Passed

        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.top();
        System.out.println(minStack.top());
    }
}
