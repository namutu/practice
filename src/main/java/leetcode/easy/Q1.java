package leetcode.easy;

public class Q1 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 1, 1, 1, 1};
        int[] answer = solution(nums);

        for(int i=0 ; i<answer.length ; i++) {
            if(i<answer.length -1) {
                System.out.print(answer[i] + " ");
            } else {
                System.out.print(answer[i]);
            }
        }
    }

    private static int[] solution(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i=0 ; i<temp.length ; i++) {
            if(i == 0) {
                temp[i] = nums[i];
            } else {
                temp[i] = nums[i] + temp[i-1];
            }
        }

        return temp;
    }
}
