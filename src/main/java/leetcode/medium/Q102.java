package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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
public class Q102 {
    static class Pair {
        TreeNode node;
        int level;
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
    public static void main(String[] args) {
//        Integer[] nums = {3,9,20,null,null,15,7};
//        Integer[] nums = {1,2,3,4,null,null,5};
        Integer[] nums = {0,2,4,1,null,3,-1,5,1,null,6,null,8};
        TreeNode root = new TreeNode();
        makeTree(nums, 0, root);

        List<List<Integer>> result = levelOrder(root);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Pair p = new Pair();
        p.node = root;
        p.level = 0;
        bfs(p, list);
        System.out.println(list.toString());

        return list;
    }
    static void bfs(Pair p, List<List<Integer>> list) {
        TreeNode root = p.node;

        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        list.add(rootList);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int level = pair.level+1;
            System.out.println("level : " + level);
            TreeNode n = pair.node;
            List<Integer> subList;
            if(n.left == null && n.right == null) {
                System.out.println("level : " + level + ", continue");
                continue;
            } else {
                try {
                    subList = list.get(level);
                    System.out.println("contains : " + (level));
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("!contains : " + (level));
                    subList = new ArrayList<>();
                    list.add(subList);
                }
            }
            if(n.left != null || n.right != null) {
                if(n.left != null) {
                    subList.add(n.left.val);
                    Pair leftPair = new Pair();
                    leftPair.node = n.left;
                    leftPair.level = level;
                    queue.add(leftPair);
                }
                if(n.right != null) {
                    subList.add(n.right.val);
                    Pair rightPair = new Pair();
                    rightPair.node = n.right;
                    rightPair.level = level;
                    queue.add(rightPair);
                }
            }
        }
    }
}



















