package programmers.lv1;

import java.util.Locale;

public class Q2 {
    //신규 아이디 추천
    public static void main(String[] args) {
//        String id = "...!@BaT#*..y.abcdefghijklm";
//        String id = "z-+.^.";
//        String id = "=.=";
//        String id = "123_.def";
        String id = "abcdefghijklmn.p";
        System.out.println("before : " + id);
        String answer = solution(id);
        System.out.println("answer : " + answer);
    }
    public static String solution(String new_id) {
        return check(new_id);
    }
    public static String check(String new_id) {
        //1
        new_id = new_id.toLowerCase();
        System.out.println("1: " + new_id);
        //2
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", "");
        System.out.println("2: " + new_id);
        //3
        StringBuilder sb = new StringBuilder();
        char before = '!';
        for(char c : new_id.toCharArray()) {
            if(!(c == '.' && before == c)) sb.append(c);
            before = c;
        }
        new_id = sb.toString();
        System.out.println("3: " + new_id);
        //4
        if(new_id.startsWith(".")) new_id = new_id.substring(1, new_id.length());
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        System.out.println("4: " + new_id);
        //5
        if(new_id.equals("") || new_id == null) new_id = "a";
        System.out.println("5: " + new_id);
        //6
        if(new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if(new_id.startsWith(".")) new_id = new_id.substring(1, new_id.length());
            if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        }
        System.out.println("6: " + new_id);
        //7
        if(new_id.length() <= 2) {
            System.out.println("index : " + (new_id.length()-1));
            if(new_id.length() > 0) {
                char paddingChar = new_id.charAt(new_id.length() - 1);
                while (new_id.length() < 3) {
                    new_id = new_id + paddingChar;
                }
            }
        }
        System.out.println("7: " + new_id);
        return new_id;
    }
}
























