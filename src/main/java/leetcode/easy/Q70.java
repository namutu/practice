package leetcode.easy;

public class Q70 {
    public static void main(String[] args) {
        int n = 3;
//        int n = 31;
        int answer = climbStairs(n);
        System.out.println("answer : " + answer);
    }
    public static int climbStairs(int n) {
        int answer = climb_stairs(0, n);
        System.out.println("answer : " + answer);

        int[] memo = new int[n+1];
        int memo_answer = climb_stairs(0, n, memo);
        System.out.println("memo_answer : " + memo_answer);

        return answer;
    }

    private static int climb_stairs(int i, int n, int[] memo) {
        System.out.println("i : " + i + ", n : " + n);
        if(i > n) return 0;
        if(i == n) return 1;

        if(memo[i] > 0) return memo[i];
        memo[i] = climb_stairs(i+1, n, memo) + climb_stairs(i+2, n, memo);

        return memo[i];
    }

    public static int climb_stairs(int i, int n) {
        System.out.println("i : " + i + ", n : " + n);
        if(i > n) return 0;
        if(i == n) return 1;

        return climb_stairs(i+1, n) + climb_stairs(i+2, n);
    }

}

















