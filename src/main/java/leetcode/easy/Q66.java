package leetcode.easy;

import java.util.Arrays;

public class Q66 {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {1,2,9};
        int[] digits = {9,9,9};
//        int[] digits = {9};

        int[] answer = plusOne(digits);
        System.out.println("answer " + Arrays.toString(answer));
    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 1;
        for(int i=digits.length-1 ; i>=0 ; i--) {
            int sum = digits[i] + carry;
            if(sum >= 10) {
                carry = sum/10;
                sum = sum%10;
                digits[i] = sum;
                if(i == 0) {
                    int[] new_digits = new int[length+1];
                    new_digits[0] = 1;
                    for(int j=1 ; j<new_digits.length ; j++) {
                        new_digits[j] = digits[j-1];
                    }
                    digits = new_digits;
                }
            } else {
                carry = 0;
                digits[i] = sum;
                break;
            }
        }
        return digits;
    }
}





















