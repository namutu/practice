package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q77 {
    public static void main(String[] args) {
//        int n = 4;
//        int k = 2;
        int n = 1;
        int k = 1;

        List<List<Integer>> answer = combine(n, k);
        System.out.println("answer " + answer.toString());
    }
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=1 ; i<=n ; i++) {
            nums[i-1] = i;
        }
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> answer = new ArrayList<>();
        comb(nums, new ArrayList<>(), 0, k, answer);

        return answer;
    }
    public static void comb(int[] nums, List<Integer> output, int index, int k, List<List<Integer>> answer) {
        System.out.println("index : " + index + ", k : " + k);
        if(output.size() == k) {
            System.out.println("output [" + output.toString() + "]");
            answer.add(new ArrayList<>(output));
            return;
        }

        for(int i=index ; i<nums.length ; i++) {
            output.add(nums[i]);
            System.out.println("output : " + output.toString());
            comb(nums, output, i+1, k, answer);
            output.remove(output.size()-1);
        }
    }
}





















