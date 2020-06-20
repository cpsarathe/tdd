package csfundamental.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] ar){
        int[] nums = {3,2,1};
        Permutation obj = new Permutation();
        obj.permute(nums);

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums,0,nums.length-1,list);
        System.out.println(list);
        return list;
    }

    public void permute(int[] nums , int start, int end , List<List<Integer>> list) {
        if(start==end){
            List<Integer> subList = new ArrayList<>();
            for(int x =0 ;x<nums.length ;x++){
                subList.add(nums[x]);
            }
            list.add(subList);
            return;
        }
        for (int i = start; i <= end; i++)
        {
            swap(nums,start,i);
            permute(nums, start+1, end,list);
            swap(nums,start,i);
        }

    }

    public void swap(int[] nums , int start, int end ) {
        List<Integer> list = new ArrayList<>();
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
