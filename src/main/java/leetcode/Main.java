package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("1","1");
        boolean loop = true;
        while(loop){
            Map<String,String> test1 = new HashMap<>();
            test1.put("2","1");
            test = test1;
            loop = false;
        }
        System.out.println("debug" + test);
        String aa = "aaaaaaaaa";
        int K = 4;
        StringBuffer sb = new StringBuffer();
        int times = aa.length()/K;
        int remain = aa.length() % K;
        if(remain > 0){
            sb.append(aa.substring(0, remain));
            sb.append("-");
        }
        for(int i = 0; i < times; i++){
            sb.append(aa.substring(remain+i*K, remain+i*K+K));
            sb.append("-");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}
