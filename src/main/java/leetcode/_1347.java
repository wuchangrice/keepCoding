package leetcode;

public class _1347 {
    public int minSteps(String s, String t) {
        int[] sNums = new int[26];
        int[] tNums = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for(int i=0; i<s.length(); i++){
            sNums[chars[i]-'a']++;
            tNums[chart[i]-'a']++;
        }
        int common = 0;
        for(int i=0; i<26;i++){
            common += Math.min(sNums[i], tNums[i]);
        }
        return s.length()-common;
    }
}
