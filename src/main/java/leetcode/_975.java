package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by oukinsei on 2020/4/7.
 */
public class _975 {
    public static void main(String[] args) {
        new _975().oddEvenJumps(new int[]{2,3,1,1,4});
    }

    public int oddEvenJumps(int[] A) {
        int result = 1, len = A.length;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(A[len-1], 3);
        for(int i = len-2; i >= 0; i--){
            if(tree.containsKey(A[i])){
                int val = tree.get(A[i]);
                if(val == 0){
                }else if(val == 3){
                    result++;
                }else if(val == 2){
                    tree.put(A[i], 1);
                    result++;
                }else{
                    tree.put(A[i], 2);
                }
                continue;
            }
            int val = 0;
            Map.Entry<Integer,Integer> floorEntry = tree.floorEntry(A[i]);
            Map.Entry<Integer,Integer> ceilEntry = tree.ceilingEntry(A[i]);
            if(floorEntry  != null){
                if( floorEntry.getValue() == 1 || floorEntry.getValue() == 3){
                    val += 2;
                }
            }
            if(ceilEntry != null){
                if(ceilEntry.getValue() == 2 || ceilEntry.getValue() == 3){
                    val += 1;
                    result++;
                }
            }
            tree.put(A[i], val);
        }
        return result;
    }
}
