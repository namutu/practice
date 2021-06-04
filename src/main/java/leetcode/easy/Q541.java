package leetcode.easy;

public class Q541 {
    public static void main(String[] args) {
//        String s = "abcdefg";
//        String s = "abcd";
//        int k = 2;
//        String s = "abcdefg";
//        int k = 8;
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        String result = reverseStr(s, k);
    }
    public static String reverseStr(String s, int k) {
        boolean doReverse = true;

        char[] chars = s.toCharArray();
        int loop = s.length()/k;
        if(loop < 1) {
            loop = 1;
            k = s.length();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<=loop ; i++) {
            if(doReverse) {
                for (int j = (i*k)-1; j >= (i-1)*k; j--) {
                    System.out.println("<- i: " + i + ", j: " + j + ", k : " + k);
                    sb.append(chars[j]);
                }
                System.out.println(sb.toString());
            } else {
                for(int j=(i-1)*k ; j<i*k ; j++) {
                    System.out.println("-> i: " + i + ", j: " + j + ", k : " + k);
                    sb.append(chars[j]);
                }
                System.out.println(sb.toString());
            }
            if(doReverse) doReverse = false;
            else doReverse = true;
        }
        int remain = s.length()%k;
        if(remain != 0) {
            if(doReverse) {
                for (int i = chars.length-1; i >= chars.length-remain; i--) {
                    sb.append(chars[i]);
                }
            } else {
                for (int i = chars.length - remain; i < chars.length; i++) {
                    sb.append(chars[i]);
                }
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
}
