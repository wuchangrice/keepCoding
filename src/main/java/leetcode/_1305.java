package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/1/7.
 * All Elements in Two Binary Search Trees
 * 此题应该使用非递归遍历的方法来解
 */
public class _1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        inOrderTraverse(root1, result1);
        inOrderTraverse(root2, result2);
        return mergeSortedList(result1, result2);
    }

    private void inOrderTraverse(TreeNode root, List<Integer> result){
        if(null == root){
            return;
        }
        if(root.left != null){
            inOrderTraverse(root.left, result);
        }
        result.add(root.val);
        inOrderTraverse(root.right,result);
    }

    private List<Integer> mergeSortedList(List<Integer> result1, List<Integer> result2){
        List<Integer> result = new ArrayList<>();
        int i=0,j=0,len1,len2;
        len1 = result1.size();
        len2 = result2.size();
        while(i < len1 && j < len2){
            if(result1.get(i) <= result2.get(j)){
                result.add(result1.get(i));
                i++;
            }else{
                result.add(result2.get(j));
                j++;
            }
        }
        while(i < len1){
            result.add(result1.get(i));
            i++;
        }
        while(j < len2){
            result.add(result2.get(j));
            j++;
        }

        return result;
    }
}
