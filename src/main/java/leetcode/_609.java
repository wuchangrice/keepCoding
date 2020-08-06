package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oukinsei on 2020/7/10.
 */
public class _609 {
    public static void main(String[] args) {
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        new _609().findDuplicate(paths);
    }
    public  List<List<String>> findDuplicate(String[] paths){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> contentPath = new HashMap<>();
        for(String path : paths){
            String[] split = path.split(" ");
            for(int i = 1; i < split.length; i++){
                int index = split[i].indexOf("(");
                String fileName = split[i].substring(0, index);
                String content = split[i].substring(index);
                List<String> list = contentPath.get(content);
                if(list == null){
                    list = new ArrayList<>();
                    contentPath.put(content, list);
                }
                list.add(split[0] + "/" + fileName);
            }
        }
        for(Map.Entry<String, List<String>> entry : contentPath.entrySet()){
            if(entry.getValue().size() > 1){
                result.add(entry.getValue());}
        }
        return result;
    }
}
