package leetcode;

public class _363{
    public static void main(String[] args) {
        long[] sum = new long[]{0,7,4,1,5};
        int result = new _363().mergeSort(sum, 0, 5, 6);
        System.out.println(result);
    }

    int mergeSort(long[] sum, int start, int end, int k) {
        if (end == start+1) return Integer.MIN_VALUE; // need at least 2 to proceed
        int mid = start + (end - start)/2, cnt = 0;
        int ans = mergeSort(sum, start, mid, k);
        if (ans == k) return k;
        ans = Math.max(ans, mergeSort(sum, mid, end, k));
        if (ans == k) return k;
        long[] cache = new long[end-start];
        for (int i = start, j = mid, p = mid; i < mid; ++i) {
            while (j < end && sum[j] - sum[i] <= k) ++j;
            if (j-1 >= mid) {
                ans = Math.max(ans, (int)(sum[j-1] - sum[i]));
                if (ans == k) return k;
            }
            while (p < end && sum[p] < sum[i]) cache[cnt++] = sum[p++];
            cache[cnt++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, cnt);
        return ans;
    }
}