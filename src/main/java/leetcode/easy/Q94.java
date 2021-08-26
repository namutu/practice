package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q94 {
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
    public static void makeTree(String[] arr, int index, TreeNode root) {
        if(index >= arr.length || 2*index+1 >= arr.length || 2*index+2 >= arr.length) return;
//        if(arr[index] == null) return;

        System.out.println("root : " + arr[index]);
        root.val = Integer.parseInt(arr[index]);
        if(arr[2*index+1] != null) {
            root.left = new TreeNode(Integer.parseInt(arr[2*index+1]));
            makeTree(arr, 2*index+1, root.left);
        }
        if(arr[2*index+2] != null) {
            root.right = new TreeNode(Integer.parseInt(arr[2*index+2]));
            makeTree(arr, 2*index+2, root.right);
        }
    }
    public static void main(String[] args) {
        String[] values = {"1", null, "2", "3"};
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        makeTree(values, 0, root);
//        System.out.println(root.right.val + root.right.left.val);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        inorder(answer, root);
        return answer;
    }
    public void inorder(List<Integer> answer, TreeNode root) {
        if(root.left != null) inorder(answer, root.left);
        answer.add(root.val);
        if(root.right != null) inorder(answer, root.right);
    }
}















