package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q477 {
    public static void main(String[] args) {
//        int[] nums = {4, 14, 2};
        int[] nums = {4, 14, 4};
        int result = totalHammingDistance(nums);
        System.out.println("result : " + result);
    }
    public static int totalHammingDistance(int[] nums) {
        int result = 0;
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i+1; j<nums.length ; j++) {
                int a = nums[i];
                int b = nums[j];
                result+=hammingDistance(a, b);
            }
        }
        return result;
    }
    private static int hammingDistance(int a, int b) {
        return Integer.bitCount(a^b);
    }

    public static void comb(int[] nums, boolean[] visited, int start, int r, List<Integer> resultList) {
        if(r == 0) {
            print(nums, visited);
            int count = hammingDistance(nums, visited);
            System.out.println("count : " + count);
            resultList.add(count);
            return;
        }
        for(int i=start; i<nums.length ; i++) {
            visited[i] = true;
            comb(nums, visited, i+1, r-1, resultList);
            visited[i] = false;
        }
    }
    private static int hammingDistance(int[] nums, boolean[] visited) {
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(visited[i] == true) {
                list.add(nums[i]);
            }
        }
        int one = list.get(0);
        int two = list.get(1);
        System.out.println("one : " + one + ", two : " + two + ", hm : " + Integer.bitCount(one^two));

        if(one == two) return 0;
        return Integer.bitCount(one^two);
    }
    static void print(int[] arr, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
