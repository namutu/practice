package leetcode.easy;

import java.util.Arrays;

public class Q88 {
    public static void main(String[] args) {
//        int m = 3;
//        int n = 3;
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};

//        int m = 1;
//        int n = 0;
//        int[] nums1 = {1};
//        int[] nums2 = {};

        int m = 0;
        int n = 1;
        int[] nums1 = {0};
        int[] nums2 = {1};

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}




















