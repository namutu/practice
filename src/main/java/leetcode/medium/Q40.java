package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q40 {
    public static void main(String[] args) {
        int[] condidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> answer = combinationSum2(condidates, target);
        System.out.println("answer " + answer.toString());
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int n = candidates.length;
        boolean[] visited = new boolean[n];
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);

        comb(candidates, output, visited, 0, target, answer);

        return answer;
    }
    public static void comb(int[] candidates, List<Integer> output, boolean[] visited, int index, int target, List<List<Integer>> answer) {
        if(target == 0) {
            List<Integer> temp = new ArrayList<>(output);
            Collections.sort(temp);
            if(!answer.contains(temp)) answer.add(temp);
            return;
        }

        for(int i=index ; i<candidates.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output.add(candidates[i]);
//                System.out.println("output : " + output.toString() + ", target: " + target);
                if(target-candidates[i] >= 0) {
                    comb(candidates, output, visited, index + 1, target-candidates[i], answer);
                    output.remove(output.size() - 1);
                    visited[i] = false;
                } else {
                    output.remove(output.size()-1);
                    visited[i] = false;
                    break;
                }
            }
        }
    }
    public static int getOutputSum(List<Integer> output) {
        int sum = 0;
        for(int n : output) {
            sum += n;
        }
        return sum;
    }
}













