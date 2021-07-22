package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class Q5 {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";

        long start = System.currentTimeMillis();
        String answer = longestPalindromeOne(s);
        long end = System.currentTimeMillis();
        System.out.println("answer : " + answer + ", time : " + (end-start) + "ms");

        start = System.currentTimeMillis();
        String answer2 = longestPalindrome(s);
        end = System.currentTimeMillis();
        System.out.println("answer2 : " + answer2 + ", time : " + (end-start) + "ms");
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for(int i=0 ; i<s.length() ; i++) {
            int len1 = expandAroundCenter(s, i ,i);
            int len2 = expandAroundCenter(s, i ,i+1);
            int len = Math.max(len1, len2);
            if(len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    public static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindromeOne(String s) {
        if(s.length() <= 1) return s;

        System.out.println("origin : " + s);
        char[] sChars = s.toCharArray();
        int lowIdx = 0;
        int highIdx = sChars.length;
        char[] answer = new char[0];
        while(lowIdx < sChars.length-1) {
            char[] check = Arrays.copyOfRange(sChars, lowIdx, highIdx);
//            System.out.println("check : " + new String(check));
            if(isPalindrme(check)) {
                if(check.length > answer.length) answer = check;

                if(sChars.length-lowIdx < answer.length) break;
                else lowIdx++;

                highIdx = sChars.length;
            } else {
                highIdx--;
            }
            if(lowIdx >= highIdx) {
                highIdx = sChars.length;
            }
        }
        return new String(answer);
    }
    public static boolean isPalindrme(char[] chars) {
        Stack<Character> stack = new Stack<>();

        int mid = chars.length/2;
        for(int i=0 ; i<chars.length ; i++) {
            if(chars.length%2==1 && i==mid) continue;

            if(i<mid) stack.add(chars[i]);
            else {
                char sChar = stack.pop();
                if(chars[i] != sChar) return false;
            }
        }
        return true;
    }
}
