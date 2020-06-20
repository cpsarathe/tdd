package csfundamental.queues;

public class BasicQueue {
    Node front = null;
    Node rear = null;

    public static void main(String[] ar) {
        BasicQueue basicQueue = new BasicQueue();
        basicQueue.enqueue(10);
        basicQueue.enqueue(20);
        basicQueue.enqueue(30);
        basicQueue.printQueueItems();
        basicQueue.dequeue();
        System.out.println("********************************");
        basicQueue.printQueueItems();
        System.out.println(basicQueue.peek());
    }

    public void enqueue(int item) {
        if (front == null) {
            Node node = new Node(item);
            front = node;
            rear = node;
        } else {
            Node node = new Node(item);
            Node temp = front;
            front = rear;
            front.next = node;
            rear = node;
            front = temp;
        }
    }

    public void dequeue() {
        front = front.next;
    }

    public int peek() {
        return front.item;
    }

    public void printQueueItems(){
        Node temp = front;
        while(temp!=null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

}
