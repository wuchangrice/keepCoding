package leetcode;

/**
 * Created by oukinsei on 2020/5/1.
 */
public class Manacher {
    public static void main(String[] args) {
        new Manacher().manacher("ababa");
    }
    public int[] manacher(String s){
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String ma = sb.toString();
        int len = ma.length(), id = 0, mx = 1;
        int[] mp = new int[len];
        for(int i = 0; i < len; i++){
            mp[i] = 1;
        }
        for(int i = 1; i < len-1; i++){
            mp[i] = i < mx ? Math.min(mp[2*id-i], mx-i) : 1;
            while (i+mp[i] < len && i - mp[i] >= 0 && ma.charAt(i + mp[i]) == ma.charAt(i - mp[i])) {
                mp[i]++;
            }
            if(mx < i+mp[i]){
                mx = i+mp[i];
                id = i;
            }
        }
        return mp;
    }

//        for(int i = 1; i < count - 1; i++) {
//            //fixme: array overflow
//            //(2)第二步
//            Mp[i] = i < Mx ? min(Mp[2*ID-i], Mx-i) : 1;
//            //(3)第三步
//            //i+Mp[i] < count && i - Mp[i] >= 0 防止越界
//            while (i+Mp[i] < count && i - Mp[i] >= 0 &&Ma[i + Mp[i]] == Ma[i - Mp[i]]) {
//                Mp[i]++;
//            }
//            if(Mx < (i + Mp[i])) {
//                Mx = i + Mp[i];
//                ID = i;
//            }
//        }
//        return Mp;
//    }
}
