package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _833 {
    public static void main(String[] args) {
        String s = "vmokgggqzp";
        int[] indexs = new int[]{3,5,1};
        String[] sources = new String[]{"kg","ggq","mo"};
        String[] targets = new String[]{"s","so","bfr"};
        new _833().findReplaceString(s, indexs, sources, targets);
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuffer sb = new StringBuffer();
        quickSort(indexes, sources, targets, 0, indexes.length-1);
        int start = 0, len = S.length();
        for(int i = 0; i < indexes.length; i++){
            int index = indexes[i];
            if(index >= len || start >= len){ //out of range
                break;
            }
            if(start < index){
                sb.append(S.substring(start, index));
                start = index;//bug未更新start位置
            }
            if(index + sources[i].length() > len){//out of range

            }else if(S.substring(index, index+sources[i].length()).equals(sources[i])){
                sb.append(targets[i]);
                start = index+sources[i].length();
            }

        }
        if(start < len){
            sb.append(S.substring(start, len));
        }
        return sb.toString();
    }

    private void quickSort(int[] indexes, String[] sources, String[] targets, int start, int end){
        if(start >= end){//有问题
            return;
        }
        int mid = pivot(indexes, sources, targets, start, end);
        quickSort(indexes, sources, targets, start, mid-1);
        quickSort(indexes, sources, targets, mid+1, end);
    }

    private int pivot(int[] indexes, String[] sources, String[] targets, int start, int end){
        int left = start, right = end;
        int val = indexes[left];
        String source = sources[left];
        String target = targets[left];
        while(left < right){
            while(right > left && indexes[right] >= val){
                right--;
            }
            indexes[left] = indexes[right];
            sources[left] = sources[right];
            targets[left] = targets[right];
            while(left < right && indexes[left] <= val){
                left++;
            }
            indexes[right] = indexes[left];
            sources[right] = sources[left];
            targets[right] = targets[left];
        }
        indexes[left] = val;
        sources[left] = source;
        targets[left] = target;
        return left;
    }

}
