package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class Q20 {
    public static void main(String[] args) {
//        String s = "()";
        String s = "()[]{}";
//        String s = "(]";
//        String s = "{[]}";
//        String s = "(([]){})";
        System.out.println(isValid(s));
    }
    static HashMap<Character, Character> map = new HashMap<Character, Character>();
    static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if(chars.length%2 != 0) return false;
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<chars.length ; i++) {
            char c = chars[i];
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    if (map.get(stack.peek()) == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}












