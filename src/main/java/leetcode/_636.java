package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/7/30.
 */
public class _636 {
    //前开后闭区间的计算需要注意
    public int[] exclusiveTime(int n, List<String> logs){
        int[] result = new int[n];
        List<Helper> helpers = new ArrayList<>();
        for(String log : logs){
            String[] splits = log.split(":");
            helpers.add(new Helper(Integer.valueOf(splits[0]),"start".equals(splits[1]) ? 0 : 1, Integer.valueOf(splits[2])));
        }
        Collections.sort(helpers, (a,b)->(a.timestamp-b.timestamp));
        Stack<Helper> stack = new Stack();
        int curTimestamp = 0, curFlag = 0;
        for(Helper helper : helpers){
            if(stack.isEmpty()){
                stack.push(helper);
            }else{
                Helper peekHelper = stack.peek();
                result[peekHelper.thread] += (helper.timestamp - curTimestamp + helper.flag - curFlag);
                if(peekHelper.thread == helper.thread && helper.flag == 1){
                    stack.pop();
                }else{
                    stack.push(helper);
                }
            }
            curTimestamp = helper.timestamp;
            curFlag = helper.flag;
        }

        return result;
    }

    class Helper{
        int thread;
        int flag;//0 start, 1 end
        int timestamp;

        public Helper(int thread, int flag, int timestamp){
            this.thread = thread;
            this.flag = flag;
            this.timestamp = timestamp;
        }
    }


}
