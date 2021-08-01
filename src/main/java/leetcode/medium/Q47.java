package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {1,2,3};

        List<List<Integer>> answer = permuteUnique(nums);
        System.out.println("answer " + answer);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        int r = nums.length;
        boolean[] visited = new boolean[r];
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        perm(nums, output, visited, 0, n, r, answer);

        return answer;
    }
    public static void perm(int[] nums, List<Integer> output, boolean[] visited, int depth, int n, int r, List<List<Integer>> answer) {
        if(depth == r) {
            if(!answer.contains(output)) {
                answer.add(new ArrayList<>(output));
            }
        }
        for(int i=0 ; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output.add(nums[i]);
                perm(nums, output, visited, depth+1, n, r, answer);
                output.remove(output.size()-1);
                visited[i] = false;
            }
        }
    }
}
