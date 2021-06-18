package leetcode.medium;

import java.util.*;

public class Q22 {
    public static void main(String[] args) {
//        int n = 1;
//        int n = 3;
        int n = 4;
//        int n = 5;
//        int n = 6;

        List<String> result = generateParenthesis(n);
        System.out.println(result.toString());
    }
    public static List<String> generateParenthesis(int n) {
        char[] paretheses = new char[n*2];
        for(int i=0 ; i<paretheses.length ; i++) {
            if(i<paretheses.length/2) paretheses[i] = '(';
            else paretheses[i] = ')';
        }

        int num = paretheses.length;
        int r = paretheses.length;
        boolean[] visited = new boolean[n*2];
        char[] output = new char[paretheses.length];
        perm(paretheses, output, visited, 0, num, r);

        return result;
    }

    public static List<String> result = new ArrayList<>();
    private static void checkParenthes(Set<String> set) {
        result = new ArrayList<>(set);
        Iterator<String> iter = result.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            int check = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '(':
                        check = check+1;
                        break;
                    case ')':
                        check = check-1;
                        break;
                }
                if (check < 0) {
                    iter.remove();
                    break;
                }
            }
        }
    }
    private static void checkAndStore(char[] chars) {
        int check = 0;
        boolean store = true;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    check = check + 1;
                    break;
                case ')':
                    check = check - 1;
                    break;
            }
            if (check < 0) {
                store = false;
                break;
            }
        }
        if(store) {
            if(!result.contains(new String(chars))) {
                result.add(new String(chars));
            }
        }
    }

    public static List<String> list = new ArrayList<>();
    public static void perm(char[] parentheses, char[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            checkAndStore(output);
            return;
        }

        for(int i=0 ; i<n ; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                output[depth] = parentheses[i];
                perm(parentheses, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    public static void store(char[] output) {
        StringBuilder sb = new StringBuilder();
        for(char c : output) {
            sb.append(c);
        }
        list.add(sb.toString());
    }
}















