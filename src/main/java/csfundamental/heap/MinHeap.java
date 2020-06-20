package csfundamental.heap;

/**
 * 1. parent node always smaller than child node
 * 2. If N is index of parent then 2i+1 is left child of it and 2i+2 is right child of it. and parnet node is i/2
 * 3. Min heap is a complete binary tree . [All levels are filled, execpt possible last level]
 * 4. use array
 * 5. start from index 1
 */
public class MinHeap {

    public static void main(String[] ar) {
        int[] array = {13, 90, 11, 10, 23, 9, 12, 80, 111};
        minHeap(array);
        printHeap(array);

    }

    public static void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 1. find the last Non leaf node index
     * 2. check fot this index which is parent now
     * 3. from parent(N/2 -1) to the start index 0 , repeat steps 4 to 6.
     * 4. if left child is smaller than parent , swap it.
     * 5. if right child is smaller than parent , swap it.
     * 6. If left, right both are small then swap smallest one.
     * 7. Repeat this step until leaf node is not identified.
     */
    public static void minHeap(int[] array) {
        int start = 0;
        int length = array.length;
        int lastN = length / 2;
        for (int i = lastN - 1; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static void heapify(int[] array, int i) {
        //recursion exit
        if (isLeafNode(array, i)) {
            return;
        }
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        int length = array.length;
        int smallest = i;
        int currNodeVal = array[i];
        if (leftIdx < length && array[leftIdx] < currNodeVal) {
            smallest = leftIdx;
        }
        if (rightIdx < length && array[rightIdx] < currNodeVal) {
            smallest = rightIdx;
            if (array[rightIdx] < array[leftIdx]) {
                smallest = rightIdx;
            } else {
                smallest = leftIdx;
            }
        }

        if (i != smallest) {
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }

        //recursion exit
        if (i == smallest) {
            return;
        }
        heapify(array, smallest);
    }

    private static boolean isLeafNode(int[] array, int index) {
        if (index >= (array.length / 2) && index <= array.length) {
            return true;
        }
        return false;
    }
}
