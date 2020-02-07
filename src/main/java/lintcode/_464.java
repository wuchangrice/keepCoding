package lintcode;

public class _464 {
    public void sortIntegers2(int[] A) {
        // write your code here
        helper(A, 0, A.length-1);
    }

    private void helper(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int partition = partition(nums,left, right);
        helper(nums, left, partition-1);
        helper(nums, partition+1, right);
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while(left < right){
            while(nums[right] >= pivot && right > left){
                right--;
            }
            nums[left]=nums[right];
            while(nums[left] <= pivot && left < right){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
