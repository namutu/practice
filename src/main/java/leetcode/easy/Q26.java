package leetcode.easy;

public class Q26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int compare = 0;
        int count = 1;
        int index = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(i == 0) {
                compare = nums[i];
                nums[index] = nums[i];
                index++;
                continue;
            }
            if(compare != nums[i]) {
                count++;
                nums[index] = nums[i];
                index++;
            }
            compare = nums[i];
        }
        return count;
    }

}
















