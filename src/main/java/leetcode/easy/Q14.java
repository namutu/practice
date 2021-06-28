package leetcode.easy;

public class Q14 {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        String answer = longestCommonPrefix(strs);
        System.out.println("answer : " + answer);
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();

        int loop = strs.length;
        char temp = ' ';
        int index = 0;
        while(true) {
            for(int i=0 ; i<loop ; i++) {
                if(index >= strs[i].length()) {
                    System.out.println("3333");
                    return answer.toString();
                }
                char[] chars = strs[i].toCharArray();
                if (temp == ' ') {
                    System.out.println("1111 temp : " + temp + ", char["+index+"] : " + chars[index]);
                    temp = chars[index];
                } else {
                    System.out.println("2222 temp : " + temp + ", char["+index+"] : " + chars[index]);
                    if (temp != chars[index]) {
                        return answer.toString();
                    }
                }
            }
            answer.append(temp);
            temp = ' ';
            index++;
        }
    }
}
