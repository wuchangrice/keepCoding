package leetcode;

/**
 * Created by oukinsei on 2020/7/9.
 */
class HitCounter {
    int[] count = new int[300];
    int result = 0;
    int curMin = 0;
    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timestamp - curMin >= 600){
            result = 1;
            for(int i = 0; i < 300; i++){
                count[i] = 0;
            }
            count[timestamp%300]++;
            curMin = timestamp;
        }
        while(timestamp - curMin >= 300){
            result -= count[curMin%300];
            curMin++;
        }
        count[timestamp%300]++;
        result++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(timestamp - curMin >= 600){
            result = 0;
            for(int i = 0; i < 300; i++){
                count[i] = 0;
            }
            curMin = timestamp;
            return result;
        }
        while(timestamp - curMin >= 300){
            result -= count[curMin%300];
            curMin++;
        }
        return result;
    }

    //["HitCounter","hit","hit","hit","hit","hit","hit","getHits","hit","getHits","hit","getHits"]
    //[[],[100],[282],[411],[609],[620],[744],[879],[956],[976],[998],[1055]]

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(100);
        hitCounter.hit(282);
        hitCounter.hit(411);
        hitCounter.hit(609);
        hitCounter.hit(620);
        hitCounter.hit(744);
        hitCounter.getHits(879);
        hitCounter.hit(956);
        hitCounter.getHits(976);
        hitCounter.hit(998);
        hitCounter.getHits(1055);
    }
}