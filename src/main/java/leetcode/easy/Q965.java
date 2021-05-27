package leetcode.easy;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    boolean checkNumsByDfs() {
        TreeNode root = this;
        int checkNum = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode r = stack.pop();
            if(r.left != null) {
                if (r.left.val == checkNum) stack.push(r.left);
                else return false;
            }
            if(r.right != null) {
                if (r.right.val == checkNum) stack.push(r.right);
                else return false;
            }
        }
        return true;
    }
}

public class Q965 {
    void makeTree(int[] nums, int index, TreeNode root) {
        if(index >= nums.length || 2*index+1 >= nums.length || 2*index+2 >= nums.length) return;
        root.val = nums[index];
        TreeNode left = new TreeNode(nums[2*index+1]);
        TreeNode right = new TreeNode(nums[2*index+2]);
        root.left = left;
        root.right = right;
        makeTree(nums, 2*index+1, root.left);
        makeTree(nums, 2*index+2, root.right);
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};

        Q965 q = new Q965();
        TreeNode root = new TreeNode();
        q.makeTree(nums, 0, root);

        boolean result = root.checkNumsByDfs();
        System.out.println("result : " + result);
    }
}

















