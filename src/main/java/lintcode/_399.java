package lintcode;

public class _399 {
    public static class NBComparator {
      public int cmp(String a, String b){
          char[] charsA = a.toCharArray();
          char[] charsB = b.toLowerCase().toCharArray();
          if(charsA[0] > charsB[0]){
              return 1;
          }else if(charsA[0] < charsB[0]){
              return -1;
          }else{
              return 0;
          }
      }
    }

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        helper(nuts,bolts,0, nuts.length-1, compare);
        return ;

    }

    private int sortNuts(String nut, String[] bolts, int start, int end, NBComparator comparator){
        //return bolt
        while(start < end){
            while(comparator.cmp(nut, bolts[start]) == 1){
                start++;
            }
            while(comparator.cmp(nut, bolts[end]) == -1){
                end--;
            }
            String temp = bolts[start];
            bolts[start]= bolts[end];
            bolts[end] = temp;
        }
        return start;
    }

    private int sortBolts(String bolt, String[] nuts, int start, int end, NBComparator comparator){
        //return nut
        while(start < end){
            while(comparator.cmp(nuts[start], bolt) == -1){//1.此处调换了比较顺序之后，比较的数值也要变动
                start++;
            }
            while(comparator.cmp(nuts[end], bolt) == 1){
                end--;
            }
            String temp = nuts[start];
            nuts[start]= nuts[end];
            nuts[end] = temp;
        }
        return start;
    }

    private void helper(String[] nuts, String[] bolts, int start, int end, NBComparator comparator){
        if(start >= end){
            return;
        }
        int partition = sortNuts(nuts[start], bolts, start, end, comparator);
        sortBolts(bolts[partition], nuts, start, end, comparator);
        helper(nuts,bolts,start,partition-1, comparator);
        helper(nuts,bolts,partition+1, end, comparator);
    }

    public static void main(String[] args) {
        String[] nuts = new String[]{"b","d","c","a"};
        String[] bolts = new String[]{"A", "C", "D", "B"};
        new _399().sortNutsAndBolts(nuts, bolts, new NBComparator());
        System.out.println(String.valueOf(nuts));
        System.out.println(String.valueOf(bolts));
    }


}
