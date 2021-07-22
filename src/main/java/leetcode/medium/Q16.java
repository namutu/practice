package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Q16 {
    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
//        int target = 1;

//        int[] nums = {0,0,0};
//        int target = 1;

//        int[] nums = {1,1,-1};
//        int target = 2;

        int[] nums = {1,1,1,1};
        int target = 0;
        int answer = threeSumClosest(nums, target);
        System.out.println("target : " + target);
        System.out.println("answer : " + answer);
    }
    public static int threeSumClosest(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                for(int t=j+1 ; t<nums.length ; t++) {
                    int sum = nums[i] + nums[j] + nums[t];
                    System.out.println("sum : " + sum);
                    list.add(sum);
                }
            }
        }

        System.out.println(list.toString());
        if(list.size() == 1) return list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int n : list) {
            if(n < target) left.add(n);
            else if(n > target) right.add(n);
            else return n;
        }
        Collections.sort(left);
        Collections.sort(right);
        if(left.size() == 0) return right.get(0);
        if(right.size() == 0) return left.get(left.size()-1);
        int largeLeft = left.get(left.size()-1);
        int smallRight = right.get(0);
        System.out.println(largeLeft + ":" + smallRight);
        if(Math.abs(target-largeLeft) > Math.abs(target-smallRight)) return smallRight;
        else return largeLeft;
    }
}
