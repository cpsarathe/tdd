package csfundamental.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {

    public static void main(String[] ar) {
        PermutationSequence obj = new PermutationSequence();
        String output = obj.getPermutation(3, 3);
        System.out.println(output);
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int x = 1; x <= nums.length; x++) {
            nums[x - 1] = x;
        }
        List<String> list = permute(nums);
        String output = list.get(k - 1);
        return output;

    }

    public List<String> permute(int[] nums) {
        List<String> list = new ArrayList<>();
        permute(nums, 0, nums.length - 1, list);
        System.out.println(list);
        return list;
    }

    public void permute(int[] nums, int start, int end, List<String> list) {
        if (start == end) {
            String str = "";
            for (int x = 0; x < nums.length; x++) {
                str = str + nums[x];
            }
            list.add(str);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, end, list);
            swap(nums, start, i);
        }

    }

    public void swap(int[] nums, int start, int end) {
        List<Integer> list = new ArrayList<>();
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
