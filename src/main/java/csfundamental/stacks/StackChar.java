package csfundamental.stacks;


public class StackChar {
    Node top = null;
    String name = null;

    public StackChar(String name) {
        this.name = name;
    }

    public void push(char ch) {
        Node newNode = new Node(ch);
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

    public void printStackItems() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.ch);
            temp = temp.next;
        }
    }
}
