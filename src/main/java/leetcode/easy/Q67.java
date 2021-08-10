package leetcode.easy;

import java.util.Arrays;
import java.util.Calendar;

public class Q67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        String answer = addBinary(a, b);
        System.out.println("answer : " + answer);
    }
    public static String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int length = 0;
        if(aArr.length >= bArr.length) length = aArr.length;
        else length = bArr.length;

        char[] naArr = new char[aArr.length];
        for(int i=aArr.length-1 ; i>=0 ; i--) {
            naArr[naArr.length-i-1] = aArr[i];
        }
        char[] nbArr = new char[bArr.length];
        for(int i=bArr.length-1 ; i>=0 ; i--) {
            nbArr[nbArr.length-i-1] = bArr[i];
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aVal = 0;
        int bVal = 0;
        for(int i=0 ; i<=length ; i++) {
            System.out.println("aVal : " + aVal + ", bVal : " + bVal + ", carry : " + carry);
            if(i>naArr.length-1 && i>nbArr.length-1 && carry < 1) break;
            if(i>naArr.length-1) aVal = 0;
            else aVal = Character.digit(naArr[i], 10);
            if(i>nbArr.length-1) bVal = 0;
            else bVal = Character.digit(nbArr[i], 10);

            int sum = aVal + bVal + carry;
            if(sum > 1) {
                carry = 1;
                sb.append(sum%2);
            } else {
                carry = 0;
                sb.append(sum%2);
            }
        }
        System.out.println("answer : " + sb.toString());
        sb.reverse();
        System.out.println("answer : " + sb.toString());

        return sb.toString();
    }
}
















