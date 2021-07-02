package leetcode.easy;

public class Q7 {
    public static void main(String[] args) {
//        int x = 123;
//        int x = -123;
//        int x = 0;
        int x = 1534236469;

        int answer = reverse(x);

        System.out.println("answer : " + answer);
    }
    public static int reverse(int x) {
        if(x == 0) return 0;
        char[] chars = (x+"").toCharArray();

        boolean isMinus = false;
        if(chars[0] == '-') isMinus = true;

        int startIndex = 0;
        if(isMinus) startIndex = 1;

        char[] result = new char[chars.length-startIndex];
        for(int i=chars.length-1 ; i >= startIndex ; i--) {
            result[chars.length-1-i] = chars[i];
        }

        int answer = 0;
        try {
            if (isMinus) answer -= Integer.parseInt(new String(result));
            else answer = Integer.parseInt(new String(result));
        } catch (NumberFormatException e) {
            return 0;
        }

        return answer;
    }
}
