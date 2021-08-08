package leetcode.easy;

public class Q53 {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {5,4,-1,7,8};
        int[] nums = {-2, -1};

        int answer = maxSubArray(nums);
        System.out.println("answer : " + answer);
    }
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int largeNum = Integer.MIN_VALUE;
        int current = 0;
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i ; j<nums.length ; j++) {
                current+=nums[j];
                if(current > largeNum) largeNum = current;
            }
            current = 0;
        }
        return largeNum;
    }
}
