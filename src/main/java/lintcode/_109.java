package lintcode;

public class _109 {
    public int minimumTotal(int[][] triangle) {
        //递推公式:M(i)=min(M(i-1),M(i))+ai
        int m = triangle.length;
        int ret = Integer.MAX_VALUE;
        if(m < 1){
            return 0;
        }
        int[] result = new int[m];
        int level = 1;
        for(int i=0; i<m; i++){
            for(int j=level-1; j>=0;j--){ //1.注意新增的数据不能污染原来的数据
                if(j==0){
                    result[j] = result[j] + triangle[i][j];
                }else if(j==level-1){
                    result[j] = result[j-1] + triangle[i][j];
                }else{
                    result[j] = Math.min(result[j-1], result[j]) + triangle[i][j];
                }
            }
            level++;
        }
        for(int i=0; i<m;i++){
            ret = Math.min(ret, result[i]);
        }
        return ret;
    }
}
