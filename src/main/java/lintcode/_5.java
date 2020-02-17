package lintcode;

public class _5 {
    //kth largest element
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return helper(nums, 0 , nums.length-1, nums.length-n);
    }

    private int helper(int[] nums, int left, int right, int k){
        int partition = partition(nums, left, right);
        while(partition != k){
            if(partition < k){
                partition = partition(nums, partition+1, right);
            }else{
                partition = partition(nums, left, partition -1);
            }
        }
        return nums[partition];
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while(left < right){
            while(right > left && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,2,5,9,3};
        int result = new _5().kthLargestElement(3,nums);
        System.out.println(result); //expect 5
    }
}
