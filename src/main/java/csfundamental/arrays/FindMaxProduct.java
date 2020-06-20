package csfundamental.arrays;

import java.util.Arrays;

/**
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=510655302929581
 *
 */

public class FindMaxProduct {

    public static void main(String[] ar) {
        int nums[] = {1, 2, 3, 4, 5};
        FindMaxProduct obj = new FindMaxProduct();
        int[] output = obj.findMaxProduct(nums);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    int[] getArrayCopy(int[] arr, int start, int end) {
        int[] arry = new int[end + 1];
        for (int i = 0; i < arry.length; i++) {
            arry[i] = arr[i];
        }
        return arry;
    }

    int findProduct(int[] arr , int CAP) {
        int result = 1;
        int iterations = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(iterations==CAP){
                break;
            }
            result = result * arr[i];
            iterations++;
        }
        return result;
    }

    int[] findMaxProduct(int[] arr) {
        // Write your code here
        int[] output = new int[arr.length];

        for (int i = 0; i < 2; i++) {
            output[i] = -1;
        }

        for (int i = 2; i < arr.length; i++) {
            int[] aCopy = getArrayCopy(arr, 0, i);
            if (aCopy.length <= 3) {
                output[i] = findProduct(aCopy,3);
            } else {
                Arrays.sort(aCopy);
                output[i] = findProduct(aCopy,3);
            }
        }

        return output;

    }
}
