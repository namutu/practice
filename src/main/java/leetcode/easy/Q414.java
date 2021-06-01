package leetcode.easy;

import java.util.*;

public class Q414 {
    public static void main(String[] args) {
//        int[] nums = {3,2,1};
        int[] nums = {1,2};

        int result = solution(nums);
        System.out.println("result : " + result);
    }
    public static int solution(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++) {
            list.add(nums[i]);
        }
        Set<Integer> set = new HashSet<>(list);
        list = new ArrayList<>(set);

        Collections.sort(list, Comparator.reverseOrder());

        if(list.size() >= 3) {
            return list.get(2).intValue();
        } else {
            return list.get(0).intValue();
        }
    }
}
