package programmers.lv1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q1 {
    //로또의 초고 순위와 최저 순위
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};

        int[] answer = solution(lottos, win_nums);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int equalCount = 0;
        int zeroCount = 0;
        for(int n : lottos) {
            if(n != 0) {
                for(int w : win_nums) {
                    if(n == w) equalCount++;
                }
            } else {
                zeroCount++;
            }
        }
        int[] answer = new int[2];

        int max = 7-(equalCount+zeroCount);
        int min = 7-equalCount;
        if(max > 6) max = 6;
        if(min > 6) min = 6;
        answer[0] = max;
        answer[1] = min;
        return answer;
    }

}
