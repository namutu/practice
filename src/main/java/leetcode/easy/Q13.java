package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q13 {
    public static void main(String[] args) {
//        String s = "III";
//        String s = "IV";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";
        int answer = romanToInt(s);
        System.out.println("answer : " + answer);
    }
    static Map<String, Integer> romanMap = new HashMap<>();
    static Map<String, Integer> specialMap = new HashMap<>();
    public static int romanToInt(String s) {
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);

        int result = 0;

        char[] chars = s.toCharArray();
        for(int i=0 ; i<chars.length ; i++) {
            if(i < chars.length-1) {
                String check = String.valueOf(chars[i]) + String.valueOf(chars[i+1]);
                System.out.println("chars[i] : " + chars[i] + ", chars[i+1] : " + chars[i+1] + ", check : " + check);
                if (specialMap.containsKey(check)) {
                    result += specialMap.get(check);
                    i++;
                } else {
                    result += romanMap.get(String.valueOf(chars[i]));
                }
            } else {
                result += romanMap.get(String.valueOf(chars[i]));
            }
        }

        return result;
    }
}






















