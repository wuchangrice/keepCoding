package leetcode;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oukinsei on 2020/5/19.
 */
public class _759 {
    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    //[
    // [[7,24],[29,33],[45,57],[66,69],[94,99]],
    // [[6,24],[43,49],[56,59],[61,75],[80,81]],
    // [[5,16],[18,26],[33,36],[39,57],[65,74]],
    // [[9,16],[27,35],[40,55],[68,71],[78,81]],
    // [[0,25],[29,31],[40,47],[57,87],[91,94]]
    // ]

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval[]{ new Interval(7,24)}));
        schedule.add(Arrays.asList(new Interval[]{ new Interval(7,24)}));
        schedule.add(Arrays.asList(new Interval[]{ new Interval(7,24)}));
        schedule.add(Arrays.asList(new Interval[]{ new Interval(7,24)}));
        schedule.add(Arrays.asList(new Interval[]{ new Interval(7,24)}));
        new _759().employeeFreeTime(schedule);

    }
    public List<Interval> employeeFreeTime2(List<List<Interval>> schedule){
        List<Interval> merged = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        schedule.forEach(a->merged.addAll(a));
        Collections.sort(merged,(a,b)->(a.start-b.start));
        int curMaxEnd = merged.get(0).end;
        for(Interval interval : merged){
            if(curMaxEnd < interval.start){
                result.add(new Interval(curMaxEnd, interval.start));
            }
            curMaxEnd = Math.max(curMaxEnd, interval.end);
        }
        return result;
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        while(schedule.size() > 1){
            int len = schedule.size(), nextLen = (len+1)/2, step = nextLen;
            for(int i = 0; i < nextLen; i++){
                if(i+step < len) {
                    schedule.set(i, merge(schedule.get(i), schedule.get(i + step)));
                }
            }
            for(int i = nextLen; i < len; i++) {
                schedule.remove(nextLen);
            }
        }
        int maxEnd = Integer.MIN_VALUE;
        List<Interval> list = schedule.get(0);
        for(Interval interval : list){
            if(maxEnd < interval.start){
                if(maxEnd > Integer.MIN_VALUE){
                    result.add(new Interval(maxEnd, interval.start));
                }
            }
            maxEnd = Math.max(maxEnd, interval.end);
        }
        return result;
    }

    private List<Interval> merge(List<Interval> l1, List<Interval> l2){
        List<Interval> result = new ArrayList<>();
        int len1 = l1.size(), len2 = l2.size(), i1 = 0, i2 = 0;
        while(i1 < len1 && i2 < len2){
            if(l1.get(i1).start <= l2.get(i2).start){
                result.add(l1.get(i1));
                i1++;
            }else{
                result.add(l2.get(i2));
                i2++;
            }
        }
        while(i1 < len1){
            result.add(l1.get(i1));
            i1++;
        }
        while(i2 < len2){
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }
}
