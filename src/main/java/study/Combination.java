package study;

public class Combination {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int r = 3;
        int[] output = new int[r];
        boolean[] visited = new boolean[nums.length];

        comb(nums, output, visited, 0, r);
    }
    public static void comb(int[] nums, int[] output, boolean[] visited, int start, int r) {
        if(r == 0) {
            return;
        }

        for(int i=0 ; i<nums.length ; i++) {

        }
    }
}


















