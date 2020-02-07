package leetcode;

public class _75 {
    public void sortColors(int[] nums) {
        int partition = partition(nums, 0 , nums.length - 1, 1);
        partition(nums, 0, partition, 1);
        partition(nums, partition, nums.length-1, 2);
    }

    private int partition(int[] nums, int left, int right, int pivot){
        while(left < right){
            while(nums[left] < pivot && left < right) {
                left++;
            }
            while(nums[right] >= pivot && right > left){
                right--;
            }
            if(left<right) { //1.此处的判断条件(易出错点)
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new _75().sortColors(nums);
        System.out.println(nums);
    }
}
