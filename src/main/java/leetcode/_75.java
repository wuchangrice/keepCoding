package leetcode;

public class _75 {
    public void sortColors(int[] nums) {
        int partition = partition(nums, 0 , nums.length - 1, 1);
        partition(nums, partition, nums.length-1, 2);
    }

    private int partition(int[] nums, int left, int right, int pivot){ //函数的作用是讲小于pivot的数一道patition的左边
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
        new _75().sortColors3(nums,6);
        System.out.println(nums);
    }

    //拓展更通用的方法，color数超过3种时
    public void sortColors(int[] nums, int n) {//n为颜色的种树
        int partition = 0;
        for(int i=1; i<n; i++){
            partition = partition(nums, partition, nums.length-1, i);
        }
    }

    //快慢指针，很难想到的答案
    void sortColors2(int A[], int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }
    //时间复杂度可能有问题，标准答案
    void sortColors3(int A[], int n) {
        int j = 0, k = n-1; //j为0的储存位置，k为2的储存位置
        for (int i=0; i <= k; i++) {
            if (A[i] == 0)
                swap(A,i, j++);
            else if (A[i] == 2)
                swap(A, i--, k--);
        }
    }
}
