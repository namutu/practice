package leetcode.easy;

import java.util.*;

public class AddStrings {
    public static void main(String[] args) {
//        String num1 = "6913259244";
//        String num2 = "71103343";
        String num1 = "1";
        String num2 = "9";
        String answer = addStrings(num1, num2);
        System.out.println("answer : " + answer);
    }

    public static String addStrings(String num1, String num2) {
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        System.out.println("num1Chars : " + Arrays.toString(num1Chars));
        char[] num1s = new char[num1Chars.length];
        for(int i=num1Chars.length-1 ; i>=0 ; i--) {
            num1s[num1.length()-1-i] = num1Chars[i];
        }
        System.out.println("num1s : " + Arrays.toString(num1s));

        System.out.println("num2Chars : " + Arrays.toString(num2Chars));
        char[] num2s = new char[num2Chars.length];
        for(int i=num2Chars.length-1 ; i>=0 ; i--) {
            num2s[num2.length()-1-i] = num2Chars[i];
        }
        System.out.println("num2s : " + Arrays.toString(num2s));

//        int length = 0;
//        if(num1Chars.length >= num2Chars.length) length = num1Chars.length;
//        else length = num2Chars.length;
//
//        System.out.println("length : " + length);

        List<Character> answer = new ArrayList<>();
        int index = 0;
        int carry = 0;
        int int_num1 = 0;
        int int_num2 = 0;
        while(true) {
            if(index >= num1s.length && index >= num2s.length && carry == 0) break;
            if(index >= num1s.length) int_num1 = 0;
            else int_num1 = Character.getNumericValue(num1s[index]);

            if(index >= num2s.length) int_num2 = 0;
            else int_num2 = Character.getNumericValue(num2s[index]);

            int current = int_num1 + int_num2 + carry;

            if(current >= 10) {
                carry = 1;
                current = current%10;
            } else {
                carry = 0;
            }
            System.out.println("index : " + index + ", num1 : " + int_num1 + ", num2 : " + int_num2 + ", current : " + current + ", carry : " + carry);

            answer.add(Character.forDigit(current, 10));
            System.out.println("Char : " + Character.forDigit(current, 10));
            index++;
        }

        System.out.println("answer " + answer.toString());
        Collections.reverse(answer);
        System.out.println("answer " + answer.toString());

        StringBuilder sb = new StringBuilder();
        for(Character c : answer) {
            sb.append(c);
        }
        System.out.println("sb : " + sb.toString());

        return sb.toString();
    }
}
























