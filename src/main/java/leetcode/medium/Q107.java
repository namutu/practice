package leetcode.medium;

import java.util.*;

public class Q107 {
    public static void main(String[] args) {
         Integer[] nums = {3,9,20,null,null,15,7};

         TreeNode root = new TreeNode();
         makeTree(nums, 0, root);

         List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(result.toString());

    }
    public static void makeTree(Integer[] nums, int index, TreeNode root) {
        if(index>=nums.length || 2*index+1>=nums.length || 2*index+2>=nums.length) return;
        root.val = nums[index].intValue();
        if(nums[2*index+1] != null) {
            TreeNode left = new TreeNode(nums[2 * index + 1].intValue());
            root.left = left;
            makeTree(nums, 2 * index + 1, left);
        }
        if(nums[2*index+2] != null) {
            TreeNode right = new TreeNode(nums[2 * index + 2].intValue());
            root.right = right;
            makeTree(nums, 2 * index + 2, right);
        }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null) return resultList;

            Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int qSize = queue.size();
            for(int i=0 ; i<qSize ; i++) {
                TreeNode n = queue.poll();
                subList.add(n.val);
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            resultList.add(subList);
        }

        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i=resultList.size()-1 ; i>=0 ; i--) {
            reverseList.add(resultList.get(i));
        }

        return reverseList;
    }
}
