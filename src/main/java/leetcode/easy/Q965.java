package leetcode.easy;

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

















