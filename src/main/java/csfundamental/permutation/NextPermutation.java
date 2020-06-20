package csfundamental.permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class NextPermutation {
    public static void main(String[] ar){
        int[] nums = {1,1,5};
        NextPermutation obj = new NextPermutation();
        List<Integer> list = new ArrayList<>();
        obj.permute(nums,0,nums.length-1 , list);
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        int input = 0; String str = "";
        for (int x = 0; x < nums.length; x++) {
            str = str + nums[x];
        }
        input = Integer.parseInt(str);
        int output = 0;
        for(Integer x : treeSet){
            if(x > input){
                output = x;
                break;
            }
        }
        if(output==0){
            output = treeSet.first();
        }
        System.out.println(output);
    }

    public void permute(int[] nums,int start,int end,List<Integer> list){
        if(start==end) {
            String str = "";
            for (int x = 0; x < nums.length; x++) {
                str = str + nums[x];
            }
            list.add(Integer.parseInt(str));
        }
        for(int i=start;i<=end;i++){
           swap(nums,start,i);
           permute(nums,start+1,end,list);
           swap(nums,start,i);
        }
    }
    public void swap(int[] nums , int start, int end ) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
