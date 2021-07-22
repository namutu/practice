package leetcode.easy;

import java.util.Arrays;

public class Q35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;

        int answer = searchInsert(nums, target);
        System.out.println("answer : " + answer);
    }
    public static int searchInsert(int[] nums, int target) {
        int findIndex = Arrays.binarySearch(nums, target);
        System.out.println("findIndex : " + findIndex);
        if(findIndex > 0) return findIndex;
        else {
            if(findIndex == 0) return 0;
            else if(Math.abs(findIndex) > nums.length) return nums.length;
            else return Math.abs(findIndex)-1;
        }
    }
}















