package leetcode;

/**
 * Created by oukinsei on 2020/3/10.
 */
public class _1007 {
    public int minDominoRotations(int[] A, int[] B) {
        if(A.length < 2){
            return 0;
        }
        int[] candidates = new int[2];
        if(A[0] == B[1] || A[0] == A[1]){
            candidates[0] = A[0];
        }
        if(B[0] == B[1] || B[0] == A[1]){
            if(candidates[0] == 0 || candidates[0] == B[0]){
                candidates[0] = B[0];
            }else{
                candidates[1] = B[0];
            }
        }
        for(int candidate : candidates){
            if(candidate == 0){
                return -1;
            }
            int countA = 0, countB = 0;
            boolean valid = true;
            for(int i = 0; i < A.length; i++){
                if(A[i] != candidate && B[i] != candidate){
                    valid = false;
                    break;
                }
                if(A[i] == candidate){
                    countA++;
                }
                if(B[i] == candidate){
                    countB++;
                }
            }
            if(valid){
                return Math.min(A.length - countA, A.length - countB);
            }
        }
        return -1;
    }
}
