package leetcode.medium;


public class Q105 {
    class TreeNode {
        int val;
        leetcode.medium.TreeNode left;
        leetcode.medium.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, leetcode.medium.TreeNode left, leetcode.medium.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int[] inorder = {3,9,20,15,7};
        int[] preorder = {9,3,15,20,7};

        buildTree(inorder, preorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        preorder root,left,right
//        inorder left,root,right
        int index = 0;

        return null;
    }
}

























