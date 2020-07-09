package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/6/30.
 */
public class _692 {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        new _692().topKFrequent(words, 3);
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCount = new HashMap<>();
        List<String> result = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                if(o1.getValue() == o2.getValue()){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });
        for(String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()){
            if(pq.size() < k){
                pq.offer(entry);
                continue;
            }
            Map.Entry<String,Integer> top = pq.peek();
            if(compare(top, entry) < 0){
                pq.poll();
                pq.offer(entry);
            }
        }
        while(!pq.isEmpty()){
            Map.Entry<String,Integer> entry = pq.poll();
            result.add(0, entry.getKey());
        }
        return result;
    }

    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
        if(o1.getValue() == o2.getValue()){
            return o2.getKey().compareTo(o1.getKey());
        }
        return o1.getValue() - o2.getValue();
    }
}
