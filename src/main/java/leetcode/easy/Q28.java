package leetcode.easy;

public class Q28 {
    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";

        String haystack = "";
        String needle = "";

        int answer = strStr(haystack, needle);
        System.out.println("answer : " + answer);

    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.equals("")) return 0;

        char[] hayArr = haystack.toCharArray();
        char[] neeArr = needle.toCharArray();
        for(int i=0 ; i<hayArr.length ; i++) {
            System.out.println("i : " + i);
            if(hayArr[i] == neeArr[0]) {
                if(i+neeArr.length > hayArr.length) return -1;
                for(int j=0 ; j<neeArr.length ; j++) {
                    System.out.println("j : " + j);
                    if(hayArr[i+j] != neeArr[j]) {
                        System.out.println("hayArr["+j+"] : " + hayArr[j] + ", neeArr["+j+"] : " + neeArr[j]);
                        break;
                    }
                    if(j == neeArr.length-1) return i;
                }
            }
        }
        return -1;
    }
}
