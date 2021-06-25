package leetcode.easy;

public class Q9 {
    public static void main(String[] args) {
        int x = 12221;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }
    public static boolean isPalindrome(int x) {
        String num = x+"";

        char[] chars = num.toCharArray();
        for(int i=0 ; i<num.length()/2 ; i++) {
            System.out.println(chars[i] + ", " + chars[num.length()-1-i]);
            if(chars[i] != chars[num.length()-1-i]) {
                return false;
            }
        }
        return true;
    }
}
