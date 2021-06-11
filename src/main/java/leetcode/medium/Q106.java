package leetcode.medium;

import java.util.HashMap;

public class Q106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        buildTree(inorder, postorder);
    }
    static HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    static int postOrderIndex = 0;
    static public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0 ; i<inorder.length ; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
//        int[] reversePost = new int[postorder.length];
//        for(int i=postorder.length-1 ; i>=0 ; i--) {
//            reversePost[postorder.length-1-i] = postorder[i];
//        }
        postOrderIndex = postorder.length-1;

        TreeNode result = setTreeArr(postorder, 0, inorder.length-1);

        return result;
    }
    static TreeNode setTreeArr(int[] postOrder, int left, int right) {
        //inorder left,root,right
        //postorder left,right,root
        if(right<left) return null;

//        System.out.println("postIndex : " + postOrderIndex);
        int rootValue = postOrder[postOrderIndex--];
        int rootIndex = inorderIndexMap.get(rootValue);

        TreeNode r = new TreeNode(rootValue);

        r.right = setTreeArr(postOrder, rootIndex+1, right);
        r.left = setTreeArr(postOrder, left, rootIndex-1);
        return r;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        TreeNode(int val) { this.val = val; }
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
}
