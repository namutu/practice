package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q31 {
    public static void main(String[] args) {
//        int[] nums = {3,2,1};
//        int[] nums = {1,2,3};
//        int[] nums = {1,1,5};
        int[] nums = {1,5,1};

        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int r = nums.length;
        List<int[]> answers = new ArrayList<>();
        int[] origin = nums.clone();
        Arrays.sort(nums);
        System.out.println("origin " + Arrays.toString(origin));
        System.out.println("nums " + Arrays.toString(nums));
        perm(nums, new int[r], 0, visited, r, answers);

        boolean isEqual = false;
        int index = -1;
        for(int i=0 ; i<answers.size() ; i++) {
            int[] arr = answers.get(i);
            for(int j=0 ; j<arr.length ; j++) {
                if(origin[j] != arr[j]) break;
                if(j == arr.length-1) isEqual = true;
            }
            if(isEqual) {
                index = i+1;
                break;
            }
        }
        if(index == answers.size()) index = 0;
        System.out.println("index : " + index);
        for(int[] arr : answers) {
            System.out.println(Arrays.toString(arr));
        }
        for(int i=0 ; i<answers.get(index).length ; i++) {
            nums[i] = answers.get(index)[i];
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void perm(int[] nums, int[] output, int depth, boolean[] visited, int r, List<int[]> answers) {
        if(depth == r) {
            answers.add(output.clone());
            return;
        }

        for(int i=0 ; i<nums.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                perm(nums, output, depth+1, visited, r, answers);
                visited[i] = false;
            }
        }
    }
    private static void print(int[] output) {
        System.out.println(Arrays.toString(output));
    }
}
