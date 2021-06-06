package leetcode.medium;

import java.util.*;

class Pair {
    int val;
    int count;
}
public class Q347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
//        int[] nums = {1};
//        int k = 1;

        int[] result = topKFrequent(nums, k);
        for(int i=0 ; i<result.length ; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        HashMap<Integer, Pair> countMap = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(countMap.containsKey(nums[i])) {
                Pair p = countMap.get(nums[i]);
                p.count+=1;
                countMap.put(nums[i], p);
            } else {
                Pair p = new Pair();
                p.val = nums[i];
                p.count = 1;
                countMap.put(nums[i], p);
            }
        }
        List<Pair> list = new ArrayList<>();
        for(int p : countMap.keySet())  {
            list.add(countMap.get(p));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });

        int[] result = new int[k];
        for(int i=0 ; i<k ; i++) {
            result[i] = list.get(i).val;
        }
        return result;
    }
}















