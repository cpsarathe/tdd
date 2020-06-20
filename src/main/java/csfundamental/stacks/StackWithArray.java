package csfundamental.stacks;

public class StackWithArray {
    static int[] array = new int[5];
    static int top = 0;

    public static void main(String[] ar) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        printStackItems(array);
        pop();
        pop();
        printStackItems(array);
    }

    public static void push(int item) {
        array[top] = item;
        top++;
    }

    public static int pop() {
        int item = array[top-1];
        top = top - 1;
        return item;
    }

    public static void printStackItems(int[] array) {
        for (int i = top-1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
