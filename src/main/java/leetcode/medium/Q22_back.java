package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q22_back {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTrack(answer, new StringBuilder(), 0, 0, n);
        System.out.println(answer.toString());
        return answer;
    }
    public static void backTrack(List<String> answer, StringBuilder sb, int open, int close, int max) {
        if(sb.length() == max*2) {
            answer.add(sb.toString());
            return;
        }

        if(open < max) {
            sb.append("(");
            System.out.println("1. open : " + open + ", close : " + close + ", max : " + max);
            backTrack(answer, sb, open+1, close, max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open) {
            sb.append(")");
            System.out.println("2. open : " + open + ", close : " + close + ", max : " + max);
            backTrack(answer, sb, open, close+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

