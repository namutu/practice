package programmers.lv1;

public class Q3 {
    //숫자 문자열과 영단어
    public static void main(String[] args) {
        String s = "one4seveneight";
        int answer = solution(s);
        System.out.println("answer : " + answer);
    }
    public static int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0 ; i<numbers.length ; i++) {
            s = s.replaceAll(numbers[i], i+"");
        }
        return Integer.parseInt(s);
    }
}




























