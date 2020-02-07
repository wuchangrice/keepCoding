package leetcode;

public class _167 {
    //two sum, array is sorted and ascending
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                int[] result = new int[]{left+1, right+1};
                return result;
            }
        }
        return (new int[2]);//no use
    }
}
