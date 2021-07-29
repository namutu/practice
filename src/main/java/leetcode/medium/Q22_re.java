package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q22_re {
    public static void main(String[] args) {
        int n = 3;

        List<String> answer = generateParenthesis(n);
        System.out.println("answer " + answer);
    }
    public static List<String> generateParenthesis(int n) {
        String[] arr = new String[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = "(";
        }
        String[] output = new String[2*n];
        List<String> answer = new ArrayList<>();
        int index = 0;
        int openCount = 0;
        int closeCount = 0;
        genParen(arr, output, index, openCount, closeCount, n, answer);
        System.out.println(answer.toString());

        return answer;
    }

    private static void genParen(String[] arr, String[] output, int index, int openCount, int closeCount, int n, List<String> answer) {
        if((openCount == closeCount) && openCount == n) {
            String s = getOutputStr(output);
            answer.add(s);
            return;
        }
        for(int i=index ; i<output.length ; i++) {
            System.out.println("i : " + i + ", openCount : " + openCount + " closeCount : " + closeCount + ", index : " + index);
            if (openCount < n) {
                output[index] = "(";
                genParen(arr, output, i + 1, openCount + 1, closeCount, n, answer);
            }
            if(closeCount < openCount) {
                output[index] = ")";
                genParen(arr, output, i+1, openCount, closeCount+1, n, answer);
            }
        }
    }
    private static String getOutputStr(String[] output) {
        StringBuilder sb = new StringBuilder();
        for(String s : output) {
            sb.append(s);
        }
        return sb.toString();
    }
}






















