package csfundamental.stacks;


import java.util.Random;

public class Stack {
    public Node top = null;
    public  int maxLimit = 3;
    public int id = 0;

    public Stack() {
        this.maxLimit = maxLimit;
        this.id = new Random().nextInt(1000);
    }

    public int getMaxLimit() {
        return this.maxLimit;
    }

    public int getId() {
        return this.id;
    }

    public boolean isMaxLimitReached() {
        int elements = 0;
        Node temp  = top;
        while(temp != null){
            elements++;
            temp = temp.next;
        }
        return elements >= maxLimit;
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

    public Node pop() {
        Node temp = top;
        if (top != null) {
            top = top.next;
        }
        return temp;
    }

    public Node top() {
        return top;
    }


    public boolean isEmpty() {
        Node temp = top;
        int x  = 0;
        if (temp != null) {
            temp = temp.next;
            x++;
        }
        return x <= 0;
    }
}
