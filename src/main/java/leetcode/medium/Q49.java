package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> answer = groupAnagrams(strs);
        System.out.println("answer " + answer.toString());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        if(strs.length == 0) return answer;

        Map<Integer, List<String>> strsMap = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            int sum = 0;
            for(char c : chars) {
                sum += (int) c;
            }
            if(strsMap.containsKey(sum)) {
                strsMap.get(sum).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                strsMap.put(sum, temp);
            }
        }
        System.out.println("Map " + strsMap.toString());
        Map<Integer, String> otherMap = new HashMap<>();

        for(int index : strsMap.keySet()) {
            List<String> list = strsMap.get(index);
            while (list.size() > 0) {
                String standard = list.get(0);
                List<String> answerTemp = new ArrayList();
                answerTemp.add(standard);
                for(int i=1 ; i<list.size() ; i++) {
                    boolean com = isAnagram(standard, list.get(i));
                    System.out.println("strd : " + standard + ", com : " + list.get(i) + ", result : " + com);
                    if(com) {
                        answerTemp.add(list.get(i));
                    }
                }
                System.out.println("answerTemp " + answerTemp.toString());
                for(String s : answerTemp) {
                    strsMap.get(index).remove(s);
                }
                answer.add(answerTemp);
            }
        }

        return answer;
    }
    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Map<Character, Integer> compare = new HashMap<>();
        for(char c : aChars) {
            if(!compare.containsKey(c)) compare.put(c, 1);
            else {
                int count = compare.get(c) + 1;
                compare.put(c, count);
            }
        }
        for(char c : bChars) {
            if(!compare.containsKey(c)) return false;
            else {
                int count = compare.get(c) - 1;
                if(count < 0) return false;
                compare.put(c, count);
            }
        }
        System.out.println(compare.toString());
        return true;
    }
}


























