package leetcode;

/**
 * Created by oukinsei on 2020/3/11.
 */
public class _838{
    public static void main(String[] args) {
        new _838().pushDominoes(".L.R...LR..L..");
    }
    public String pushDominoes(String dominoes) {
        boolean currentL = true;
        char[] chars = dominoes.toCharArray();
        int l = -1, index = 0, len = dominoes.length(), r = 0;
        while(index < len){
            if(currentL) {
                while (index < len && chars[index] == '.') {
                    index++;
                }
                if(index < len) {
                    if (chars[index] == 'L') {  //ll
                        for (int j = l + 1; j < index; j++) {
                            chars[j] = 'L';
                        }
                        l = index;
                    }else{ //lr
                        currentL = false;
                        r = index;
                    }
                }
            }else{
                while(index < len && chars[index] == '.'){
                    index++;
                }
                if(index < len){
                    if (chars[index] == 'R') {  //rr
                        for (int j = r + 1; j < index; j++) {
                            chars[j] = 'R';
                        }
                        r = index;
                    }else{//rl
                        currentL = true;
                        l = index;
                        while(r < l){
                            chars[r++] = 'R';
                            chars[l--] = 'L';
                        }
                        l = index;
                    }
                }
            }
            index++;
        }
        //扫尾
        if(!currentL){
            while (r < len){
                chars[r++] = 'R';
            }
        }
        return new String(chars);
    }
}
