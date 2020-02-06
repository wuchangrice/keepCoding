package leetcode;

public class _quickSort {

    public void quickSort(int[] nums){
        recursive(nums, 0 , nums.length-1);
    }

    private void recursive(int[] nums, int left, int end){
        if(left >= end){
            return;
        }
        int partition = partition(nums, left, end);
        recursive(nums,left, partition-1);
        recursive(nums, partition+1, end);
    }

    private int partition(int[] nums, int left, int right){
        int value = nums[left];
        while(left < right){
            while(nums[right] >= value && right > left){
                right--;
            }
            nums[left] = nums[right];
            while(nums[left] <= value && left < right){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left] = value;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,7,9,1,4};
        new _quickSort().quickSort(nums);
        System.out.println(nums);
    }
}
