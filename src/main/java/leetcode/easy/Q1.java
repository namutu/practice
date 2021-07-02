package leetcode.easy;

public class Q1 {
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;
        int[] nums = {3,2,4};
        int target = 6;
        int[] answer = twoSum(nums, target);

        System.out.println("answer : [" + answer[0] + ", " + answer[1] + "]");
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                if((nums[i] + nums[j]) == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}
