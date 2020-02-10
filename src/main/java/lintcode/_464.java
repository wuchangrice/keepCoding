package lintcode;

public class _464 {
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length-1);
    }
    //quick sort
    public void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int partition = partition(nums,left, right);
        quickSort(nums, left, partition-1);
        quickSort(nums, partition+1, right);
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

    //merge sort
    public void merge(int[] nums, int[] temp, int left, int mid, int right){
        for(int i=left; i<=right; i++){
            temp[i] = nums[i];
        }
        int i=left, j=mid, k = left;
        for(; i<mid && j<=right;){
            if(temp[i] < temp[j]){ //这里的符号直接关系到排序的稳定性
                nums[k++] = temp[i++];
            }else{
                nums[k++] = temp[j++];
            }
        }
        while(i<mid){
            nums[k++] = temp[i++];
        }
        while(j<=right){
            nums[k++] = temp[j++];
        }
    }

    public void merge_sort(int[] nums,int[] temp, int left, int right){
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        merge_sort(nums, temp, left, mid);
        merge_sort(nums, temp, mid+1, right);
        merge(nums, temp , left, mid+1 ,right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,2,3};
        int[] temp = new int[nums.length];
        new _464().merge_sort(nums, temp, 0, nums.length -1);
        System.out.println(nums);
    }
}
