package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q15 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {1,2,-2,-1};
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> answer = threeSum(nums);
        System.out.println("answer " + answer.toString());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0 ; i<nums.length ; i++) {
            int low = i+1, high = nums.length-1;
            while (low < high) {
                System.out.println("nums["+i+"] : " + nums[i] + ", nums["+low+"] : " + nums[low] + ", nums["+high+"] : " + nums[high]);
                int sum = nums[i] + nums[low] + nums[high];
                if(sum < 0) low++;
                else if(sum > 0) high--;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[low]); list.add(nums[high]);
                    Collections.sort(list);
                    if(!answer.contains(list)) answer.add(list);
                    low++;
                }
            }
        }
        return answer;
    }

    public static List<List<Integer>> threeSumOne(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                for(int x=j+1 ; x<nums.length ; x++) {
                    int sum = nums[i] + nums[j] + nums[x];
                    if(sum == 0) {
                        System.out.println("nums["+i+"] : " + nums[i] + ", nums["+j+"] : " + nums[j] + ", nums["+x+"] : " + nums[x]);
                        System.out.println("sum == 0 : " + sum);
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[x]);
                        Collections.sort(list);
                        if(!answer.contains(list)) answer.add(list);
                    }
                }
            }
        }
        System.out.println("answer : " + answer.toString());
        return answer;
    }
}
