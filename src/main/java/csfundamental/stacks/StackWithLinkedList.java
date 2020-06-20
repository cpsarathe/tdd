package csfundamental.stacks;

public class StackWithLinkedList {
    static Node top;
    public static void main(String[] ar){
        push(10);
        push(20);
        push(30);
        push(40);
        printStackItems(top);
        pop();
        printStackItems(top);
    }

    public static void push(int item){
        Node node = new Node(item);
        if(top==null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public static  Node pop(){
        Node temp = null;
        if(top!=null) {
            temp = top;
            top = top.next;
        }
        return temp;
    }

    public static void printStackItems(Node top){
        while(top!=null){
            System.out.println(top.item);
            top = top.next;
        }
    }
}
