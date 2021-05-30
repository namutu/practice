package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q242 {
    public static void main(String[] args) {
        Q242 q = new Q242();
        String s = "anagram";
        String t = "nagaram";
//        String s = "rat";
//        String t = "car";
        boolean result = q.solution(s, t);
        System.out.println("result : " + result);
    }
    public boolean solution(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] sCount = new int[31];
        int[] tCount = new int[31];

        if(sArr.length != tArr.length) return false;
        for(char c : sArr) {
            int cInt = ((int) c -97);
            sCount[cInt] = sCount[cInt]+1;
        }
        for(char c : tArr) {
            int cInt = ((int) c -97);
            tCount[cInt] = tCount[cInt]+1;
        }
        for(int i=0 ; i<sCount.length ; i++) {
            if(sCount[i] == tCount[i]) continue;
            else return false;
        }
        return true;
    }
}
