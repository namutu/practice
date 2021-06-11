package leetcode.medium;


import java.util.HashMap;

public class Q105 {
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
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();
    static int preorderIndex = 0;
    public static void main(String[] args) {
        int[] inorder = {3,9,20,15,7};
        int[] preorder = {9,3,15,20,7};

        for(int i=0 ; i<inorder.length ; i++) {
            inorderMap.put(inorder[i], i);
        }

        buildTree(inorder, preorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        preorder root,left,right
//        inorder left,root,right

        TreeNode result = setTreeNode(preorder, 0, preorder.length-1);
        return result;
    }

    public static TreeNode setTreeNode(int[] preorder, int left, int right) {
        if(left>right) return null;
        TreeNode root = new TreeNode();

        int preorderValue = preorder[preorderIndex++];
        int inorderIndex = inorderMap.get(preorderValue);
        root.val = preorderValue;

        root.left = setTreeNode(preorder, left, inorderMap.get(preorderValue)-1);
        root.right = setTreeNode(preorder, inorderMap.get(preorderValue)+1, right);
        return root;
    }
}

























