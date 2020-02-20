package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oukinsei on 2020/1/16.
 * queensAttacktheKing
 */
public class _1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Map<String, DirectionDistance> resultMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int[] queen : queens){
            DirectionDistance directionDistance = judgeDirection(king, queen);
            if(null == directionDistance){
                continue;
            }
            DirectionDistance origin = resultMap.get(directionDistance.direction);
            if(origin == null){
                resultMap.put(directionDistance.direction, directionDistance);
            }else if(origin.distance > directionDistance.distance){
                resultMap.put(directionDistance.direction, directionDistance);
            }
        }
        for(Map.Entry<String, DirectionDistance> entry : resultMap.entrySet()){
            result.add(entry.getValue().location);
        }
        return result;
    }
    private class DirectionDistance{
        public String direction;
        public int distance;
        public List<Integer> location;
    }
    private DirectionDistance judgeDirection(int[] king, int[] queen){
        DirectionDistance directionDistance = new DirectionDistance();
        List<Integer> location = new ArrayList<>();
        location.add(queen[0]);
        location.add(queen[1]);
        directionDistance.location = location;
        if(king[0] == queen[0]){
            directionDistance.distance = Math.abs(queen[1] - king[1]);
            if(queen[1] > king[1]){
                directionDistance.direction = "u";
            }else{
                directionDistance.direction = "d";;
            }
            return directionDistance;
        }
        if(king[1] == queen[1]){
            directionDistance.distance = Math.abs(king[0]-queen[0]);
            if(queen[0] < king[0]){
                directionDistance.direction = "l";
            }else{
                directionDistance.direction = "r";
            }
            return directionDistance;
        }
        if(Math.abs(king[0]-queen[0]) == Math.abs(king[1] - queen[1])){
            directionDistance.distance = Math.abs(king[0]-queen[0]);
            StringBuilder sb = new StringBuilder();
            if(queen[0] < king[0]){
                sb.append("l");
            }else{
                sb.append("r");
            }
            if(queen[1] > king[1]){
                sb.append("u");
            }else{
                sb.append("d");
            }
            directionDistance.direction = sb.toString();
            return directionDistance;
        }
        return null;
    }
}
