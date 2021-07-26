package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> answer = permute(nums);
        System.out.println("answer " + answer.toString());
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] output = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        perm(nums, output, visited,0, nums.length, answer);
        return answer;
    }
    public static void perm(int[] nums, int[] output, boolean[] visited, int depth, int r, List<List<Integer>> answer) {
        if(depth == r) {
            store(output, answer);
            return;
        }
        for(int i=0 ; i<nums.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                perm(nums, output, visited, depth+1, r, answer);
                visited[i] = false;
            }
        }
    }
    public static void store(int[] output, List<List<Integer>> answer) {
        List<Integer> list = new ArrayList<>();
        for(int n : output) {
            list.add(n);
        }
        answer.add(list);
    }
    public static void print(int[] output) {
        for(int n : output) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

























