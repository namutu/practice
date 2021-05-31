package leetcode.easy;

public class Q1816 {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        String result = truncateSentence(s, k);
        System.out.println(result);
    }
    public static String truncateSentence(String s, int k) {
        String result = "";
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<k ; i++) {
            if(i < k-1) {
               sb.append(words[i] + " ");
            } else {
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
}
