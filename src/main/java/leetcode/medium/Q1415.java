package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q1415 {
    public static void main(String[] args) {
//        int n = 1, k = 3;
//        int n = 1, k = 4;
        int n = 3, k = 9;
//        int n = 2, k = 7;

        String result = getHappyString(n, k);
        System.out.println(result);
    }
    public static String getHappyString(int n, int k) {
        char[] chars = {'a', 'b', 'c'};
        boolean[] visited = new boolean[chars.length];
        char[] output = new char[n];
        List<String> list = new ArrayList<>();

        Perm(chars, output, visited, 0, chars.length, n, list);

        if(k > list.size()) return "";
        if(list.get(k-1) != null) return list.get(k-1);
        else return "";
//        List<String> resultList = new ArrayList<>();
//        for(String s : list) {
//            String result = isHappyString(s);
//            if(result != null) resultList.add(result);
//        }
//        System.out.println(resultList.toString());
//        if(k > resultList.size()) return "";
//        if(resultList.get(k-1) != null) return resultList.get(k-1);
//        else return "";
    }
    public static void Perm(char[] chars, char[] output, boolean[] visited, int depth, int n, int r, List<String> list) {
        if(depth == r) {
            storeList(list, output);
            return;
        }

        for(int i=0 ; i<n ; i++) {
            output[depth] = chars[i];
            Perm(chars, output, visited, depth+1, n, r, list);
        }
    }
    public static void storeList(List<String> list, char[] output) {
        StringBuilder sb = new StringBuilder();
        for(char c : output) {
            sb.append(c);
        }
        String happy = isHappyString(sb.toString());
        if(happy != null) list.add(happy);
    }
    public static String isHappyString(String s) {
        char[] chars = s.toCharArray();
        for(int i=0 ; i<chars.length ; i++) {
            if(i+1 > chars.length-1) break;
            if(chars[i] == chars[i+1]) return null;
        }
        return s;
    }
}
