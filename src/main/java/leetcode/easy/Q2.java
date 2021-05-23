package leetcode.easy;

public class Q2 {
    public static void main(String[] args) {
//        int num = 123;
        int num = 8;

        int result = solution(num);
        System.out.println(result);
    }
    public static int solution(int num) {
        int count = 0;
        while (true) {
            if(num == 0) break;
            if(num == 1) {
                count++;
                break;
            }
            if (num%2 == 0) {
                num = num/2;
                count++;
            } else {
                num = num-1;
                count++;
            }
        }
        return count;
    }
}
