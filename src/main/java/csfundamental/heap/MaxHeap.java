package csfundamental.heap;

/**
 * 1. parent node always greater than child node
 * 2. If N is index of parent then 2i+1 is left child of it and 2i+2 is right child of it. and parent node is i/2
 * 3. Max heap is a complete binary tree . [All levels are filled, except possible last level]
 * 4. use array
 * 5. start from index 1
 */
public class MaxHeap {

    public static void main(String[] ar) {
        int[] array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        maxHeap(array);
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
     * 4. if left child is greater than parent , swap it.
     * 5. if right child is greater than parent , swap it.
     * 6. If left, right both are bigger then swap greatest one.
     * 7. Repeat this step until leaf node is not identified.
     */
    public static void maxHeap(int[] array) {
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
        int greatest = i;
        int currNodeVal = array[i];
        if (leftIdx < length && array[leftIdx] > currNodeVal) {
            greatest = leftIdx;
        }
        if (rightIdx < length && array[rightIdx] > currNodeVal) {
            greatest = rightIdx;
            if (array[rightIdx] > array[leftIdx]) {
                greatest = rightIdx;
            } else {
                greatest = leftIdx;
            }
        }

        if (i != greatest) {
            int temp = array[i];
            array[i] = array[greatest];
            array[greatest] = temp;
        }

        //recursion exit
        if (i == greatest) {
            return;
        }
        heapify(array, greatest);
    }

    private static boolean isLeafNode(int[] array, int index) {
        if (index >= (array.length / 2) && index <= array.length) {
            return true;
        }
        return false;
    }
}
