package leetcode.medium;

import java.util.*;

public class Q12 {
    public static void main(String[] args) {
//        int num = 1994;
        int num = 58;
//        int num = 20;
        String answer = solution(num);
        System.out.println("answer : " + answer);
    }

    private static String solution(int num) {
        Map<Integer, String> symbols = new HashMap<>();
        symbols.put(1, "I"); symbols.put(5, "V"); symbols.put(10, "X"); symbols.put(50, "L");
        symbols.put(100, "C"); symbols.put(500, "D"); symbols.put(1000, "M");

        List<Integer> keys = new ArrayList<>(symbols.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);

        StringBuilder answerSb = new StringBuilder();
        findAnswerR(num, 0, keys, symbols, answerSb);
        return answerSb.toString();
    }
    private static void findAnswerR(int num, int index, List<Integer> keys, Map<Integer, String> symbols, StringBuilder answerSb) {
        if(num <= 0) return;
        int key = keys.get(index);
        int quota = num/key;
        int remain = num%key;
        if (quota > 0) {
            System.out.println("num : " + num + ", index : " + index + ", key : " + key + ", answer : " + answerSb.toString());
            answerSb.append(symbols.get(key));
            num = num - key;
        }
        if((key+"").startsWith("1")) {
//            System.out.println("num : " + num + ", index : " + index + ", key : " + key + ", answer : " + answerSb.toString());
            if(key>=10 && num/(key/10) == 9) {
                answerSb.append(symbols.get(key/10)).append(symbols.get(key));
                num = num - ((key/10)*9);
            }
        } else if((key+"").startsWith("5")) {
//            System.out.println("num : " + num + ", index : " + index + ", key : " + key + ", answer : " + answerSb.toString());
            if(key>=5 && num/(key/5) == 4) {
                answerSb.append(symbols.get(key/5)).append(symbols.get(key));
                num = num - ((key/5)*4);
            }
        }
        if(num < key) {
            index++;
        }
//        System.out.println("num : " + num + ", index : " + index + ", key : " + key + ", answer : " + answerSb.toString());
        findAnswerR(num, index, keys, symbols, answerSb);
    }
}









