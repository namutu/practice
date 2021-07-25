package study;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int r = 3;
        int[] output = new int[r];
        boolean[] visited = new boolean[nums.length];

        comb(nums, new ArrayList<>(), visited, 0, r, 0);

//        List<Integer> outputList = new ArrayList<>();
//        combDup(nums, outputList, 0, nums.length, result);
//        System.out.println("result " + result.toString());
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static void combDup(int[] nums, List<Integer> output, int depth, int n, List<List<Integer>> outputs, int start) {
        if(depth == n) {
            print(output);
            result.add(output);
            return;
        }
        for(int i=start ; i<nums.length ; i++) {
            output.add(nums[depth]);
            combDup(nums, output, depth+1, n, outputs, start+1);
            output.remove(output.size()-1);
        }
    }
    public static void comb(int[] nums, List<Integer> output, boolean[] visited, int depth, int r, int start) {
        if(depth == r) {
            print(output);
            return;
        }

        for(int i=start ; i<nums.length ; i++) {
            output.add(nums[depth]);
            comb(nums, output, visited, depth+1, r, start+1);
            output.remove(output.size()-1);
        }
    }
    public static void print(int[] output) {
        for(int n : output) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    public static void print(List<Integer> output) {
        for(int n : output) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


















