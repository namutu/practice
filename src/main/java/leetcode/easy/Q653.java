package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q653 {
    void makeTree(String[] nums, int index, TreeNode root) {
        if(index >= nums.length || 2*index+1 >= nums.length || 2*index+2 >= nums.length) return;
        if(nums[2*index+1] != null) {
            TreeNode left = new TreeNode(Integer.parseInt(nums[2 * index + 1]));
            root.left = left;
            makeTree(nums, 2*index+1, root.left);
        }
        if(nums[2*index+2] != null) {
            TreeNode right = new TreeNode(Integer.parseInt(nums[2 * index + 2]));
            root.right = right;
            makeTree(nums, 2*index+2, root.right);
        }
    }
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            System.out.print(r.val + " ");
            if (r.left != null) queue.add(r.left);
            if (r.right != null) queue.add(r.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        String[] nums = {"5","3","6","2","4",null,"7"};
//        int k = 9;
//        String[] nums = {"5","3","6","2","4",null,"7"};
//        int k = 28;
//        String[] nums = {"2","1","3"};
//        int k = 4;
//        String[] root = {"2","1","3"};
//        int k = 1;
        String[] nums = {"2",null,"3"};
        int k = 6;
//        String[] nums = {"1"};
//        int k = 2;
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(nums[0]);
        Q653 q = new Q653();
        q.makeTree(nums, 0, root);
        q.bfs(root);
        boolean result = q.findTarget(root, k);
        System.out.println("result : " + result);
    }
    List<Integer> nodeList = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root.left == null && root.right == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode r = queue.poll();
            int rootVal = r.val;
            int compare = (k - rootVal);
            if (nodeList.contains(compare)) {
                return true;
            } else {
                nodeList.add(rootVal);
                if(r.left != null) queue.add(r.left);
                if(r.right != null) queue.add(r.right);
            }
        }
        return false;
    }
}
















