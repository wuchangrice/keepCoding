package lintcode;

public class _373 {
    public void partitionArray(int[] nums) {
        int left=0, right=nums.length-1;
        while(left<right){
            while((nums[left]&1)==1 && left < right){
                left++;
            }
            while((nums[right]&1)==0 && right > left){
                right--;
            }
            if(left <right){
                swap(nums, left++, right--);
            }
        }

    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,3};
        new _373().partitionArray(nums);
        System.out.println(nums);
    }
}
