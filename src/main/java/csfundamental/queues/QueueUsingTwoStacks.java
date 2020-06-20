package csfundamental.queues;

import csfundamental.stacks.Node;
import csfundamental.stacks.Stack;

public class QueueUsingTwoStacks {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public static void main(String[] ar) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
//
//        ["MyQueue","push","push","push","peek","pop","peek","pop","peek","empty","pop","empty"]
//[[],[1],[2],[3],[],[],[],[],[],[],[],[]]
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("s1"+queue.peek());
        System.out.println("s2"+queue.pop());
        System.out.println("s3"+queue.peek());
        System.out.println("s4"+queue.pop());
        System.out.println("s5"+queue.peek());
        System.out.println("s6"+queue.empty());
        System.out.println("s7"+queue.pop());
        System.out.println("s8"+queue.empty());
    }

    /**
     * Initialize your data structure here.
     */
    public QueueUsingTwoStacks() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Node s2Temp = stack2.pop();
        if(s2Temp!=null) {
            return s2Temp.item;
        } else {
            Node temp = stack1.pop();
            while (temp != null) {
                stack2.push(temp.item);
                temp = stack1.pop();
            }
            return stack2.pop().item;
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Node s2Temp = stack2.top();
        if(s2Temp!=null){
            return s2Temp.item;
        }
        //here means stack2 is empty
        Node temp = stack1.pop();
        while (temp != null) {
            stack2.push(temp.item);
            temp = stack1.pop();
        }
        return stack2.top.item;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty() ;
    }
}
