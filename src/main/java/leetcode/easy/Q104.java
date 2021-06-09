package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q104 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
    static int bfs(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0 ; i<size ; i++) {
                TreeNode r = queue.poll();
                if(r.left!=null) queue.add(r.left);
                if(r.right!=null) queue.add(r.right);
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};

        TreeNode root = new TreeNode();
        makeTree(nums, 0, root);

        int count = bfs(root);
        System.out.println("count : " + count);

    }
}






















