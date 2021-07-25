package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> answer = combinationSum(candidates, target);
        System.out.println("answer " + answer.toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
//        combOne(candidates, new ArrayList<>(), 0, target, answer);
        combTwo(candidates, new ArrayList<>(), 0, target, answer);
        return answer;
    }
    public static void combTwo(int[] nums, List<Integer> output, int index, int target, List<List<Integer>> answer) {
        int sum = addAll(output);
        if(sum >= target) {
            System.out.println(output.toString());
            if(target == sum) answer.add(new ArrayList<>(output));
            return;
        }

        for(int i=index ; i<nums.length ; i++) {
            output.add(nums[i]);
            combTwo(nums, output, i, target, answer);
            output.remove(output.size()-1);
        }
    }

    private static int addAll(List<Integer> output) {
        int sum = 0;
        for(int n : output) {
            sum += n;
        }
        return sum;
    }

    public static void combOne(int[] nums, List<Integer> output, int index, int target, List<List<Integer>> answer) {
        if(target == 0) {
            answer.add(new ArrayList<>(output));
            return;
        }

        for(int i=index ; i<nums.length ; i++) {
            int newTarget = target-nums[i];
            if(newTarget >= 0) {
                output.add(nums[i]);
                combOne(nums, output, i, newTarget, answer);
                output.remove(output.size()-1);
            }
        }
    }
}











