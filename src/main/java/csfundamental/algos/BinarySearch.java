package csfundamental.algos;

public class BinarySearch {
    public static void main(String[] ar){
        BinarySearch binarySearch = new BinarySearch();
        int nums[] = {10,12,14,16,18,21,32,45,67};
        int val = 45;
        int result = binarySearch.findUsingBinarySearch(nums,val);
        System.out.println(result);

        int left = 0;
        int right = nums.length - 1;
        int find = binarySearch.findElementBinarySearchRecursion(nums,45,left, right);
        System.out.println(find);
    }

    public int findElementBinarySearchRecursion(int[] nums, int val , int left , int right){
        int mid = left + (right - left) / 2 ;
        if(nums[mid] == val){
            return val;
        }
        if(val < nums[mid]) {
            return findElementBinarySearchRecursion(nums,val,left, mid);
        }
        if(val > nums[mid]) {
            return findElementBinarySearchRecursion(nums,val,mid, right);
        }
        return -1;
    }
    public int findUsingBinarySearch(int[] nums, int val){
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int mid = left + (right - left) / 2;
            if(mid<left || mid>right ){
                break;
            }
            if(nums[mid]==val) {
                return nums[mid];
            }
            //if value falls in left side ignore right side
            if(val < nums[mid]){
                right = mid;
            }
            //if value falls in right side ignore left side
            if(val > nums[mid]){
                left = mid;
            }
        }

        return -1;
    }

}
