package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q4 {
    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    public void makeTree(Queue<Integer> queue, TreeNode root) {
        if(queue.peek() == null) return;
        TreeNode left = new TreeNode(queue.poll().intValue());
        TreeNode right = new TreeNode(queue.poll().intValue());
        root.left = left;
        root.right = right;
        System.out.println("root : " + root.val + ", left : " + root.left.val + ", right : " + root.right.val);
        makeTree(queue, left);
        makeTree(queue, right);
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1, 0, 1};
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<nums.length ; i++) {
            queue.add(nums[i]);
        }

        Q4 q = new Q4();
        TreeNode rootNode = new TreeNode(queue.poll().intValue());
        q.makeTree(queue, rootNode);

    }
    public int sumRootToLeaf(TreeNode root) {
        return 0;
    }
}
















