package leetcode.easy;

import java.util.Stack;

public class TreeNode {
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
