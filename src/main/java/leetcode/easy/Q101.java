package leetcode.easy;

public class Q101 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,4,4,3};
//        Integer[] nums = {1,2,2,null,3,null,3};
        TreeNode root = new TreeNode();
        makeTree(nums, 0, root);

        boolean result = isSymmetric(root);
        System.out.println("result : " + result);
    }
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    public static void makeTree(Integer[] nums, int index, TreeNode root) {
        if(index >= nums.length || 2*index+1 >= nums.length || 2*index+2 >= nums.length) return;
        root.val = nums[index].intValue();
        if(nums[2*index+1] != null) {
            TreeNode left = new TreeNode();
            left.val = nums[2*index+1].intValue();
            root.left = left;
            makeTree(nums, 2*index+1, left);
        }
        if(nums[2*index+2] != null) {
            TreeNode right = new TreeNode();
            right.val = nums[2*index+2].intValue();
            root.right = right;
            makeTree(nums, 2*index+2, right);
        }
    }
}
