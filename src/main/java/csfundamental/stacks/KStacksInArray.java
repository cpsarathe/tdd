package csfundamental.stacks;

public class KStacksInArray {

    //using two dimensional array
    //define dynamically how many stack you need , size of each stack
    public static void main(String[] ar) {
        int totalStacks = 3, eachStackSize = 3;
        int[][] array = new int[totalStacks][eachStackSize];
        int topArray[] = new int[totalStacks];
        push(10,array[0],topArray, 0);
        push(20,array[0],topArray, 0);
        push(90,array[0],topArray, 0);
        push(30,array[1],topArray, 1);
        push(40,array[1],topArray, 1);
        push(80,array[1],topArray, 1);
        push(50,array[2],topArray, 2);
        push(60,array[2],topArray, 2);
        push(70,array[2],topArray, 2);
        printStackItems(array[0]);
        System.out.println("*******************");
        printStackItems(array[1]);
        System.out.println("*******************");
        printStackItems(array[2]);
        System.out.println("*******************");
        System.out.println(pop(array[0],topArray, 0));
        System.out.println(pop(array[0],topArray, 0));
        System.out.println("*******************");
        System.out.println(pop(array[1],topArray, 1));
    }

    public static void push(int item,int array[], int[] topArray, int topIndex) {
        int top = topArray[topIndex];
        array[top] = item;
        top = top + 1;
        topArray[topIndex] = top;
    }

    public static int pop(int array[], int[] topArray, int topIndex) {
        int top = topArray[topIndex];
        int item = array[top-1];
        top = top - 1;
        topArray[topIndex] = top;
        return item;
    }

    public static void printStackItems(int[] array) {
        for (int i = array.length -1 ; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

}
