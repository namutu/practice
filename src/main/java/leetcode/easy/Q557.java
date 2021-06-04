package leetcode.easy;

import java.util.Stack;

public class Q557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        System.out.println("result : " + result);
    }
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strArr) {
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
