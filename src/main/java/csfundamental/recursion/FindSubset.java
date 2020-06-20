package csfundamental.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindSubset {

    public static void main(String[] ar){
        int nums[] = {1,2,3};
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int funcCall = 0;
        findSubSets(0,nums,current,subsets,funcCall);
        System.out.println(subsets);
    }

    public static void findSubSets(int index , int[] nums ,List<Integer> current , List<List<Integer>> subsets , int funcCall){
        subsets.add(new ArrayList<>(current));
        for(int i = index ; i< nums.length ; i++){
            current.add(nums[i]);
            funcCall = funcCall + 1;
            System.out.println("funcCall :" + funcCall);
            findSubSets(index+1,nums,current,subsets,funcCall);
        }
        System.out.println("****************************");

    }
}
