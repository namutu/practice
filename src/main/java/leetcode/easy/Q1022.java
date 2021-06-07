package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q1022 {
    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         boolean marked = false;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    class Pair {
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
        public TreeNode getNode() {
            return node;
        }
        public void setNode(TreeNode node) {
            this.node = node;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
    static class Search {
        void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode r = queue.poll();
                if (r.marked == false) {
                    System.out.print(r.val + " ");
                    r.marked = true;
                    if (!(r.left == null)) {
                        queue.add(r.left);
                    }
                    if (!(r.right == null)) {
                        queue.add(r.right);
                    }
                }
            }
        }//bfs

        void dfs(TreeNode root) {
            System.out.print("DFS : ");
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode r = stack.pop();
//                if (r.marked == false) {
                    r.marked = true;
                    System.out.print(r.val + " ");
                    if (!(r.right == null)) {
                        stack.push(r.right);
                    }
                    if (!(r.left == null)) {
                        stack.push(r.left);
                    }
//                }
            }
        }//dfs

        public void initMark() {

        }

        public void makeTree(int[] nums, int index, TreeNode node) {
            if (index >= nums.length || 2 * index + 1 >= nums.length || 2 * index + 2 >= nums.length) return;
            node.val = nums[index];
            TreeNode left = new TreeNode(nums[2 * index + 1]);
            TreeNode right = new TreeNode(nums[2 * index + 2]);
            node.left = left;
            node.right = right;
            System.out.println("index : " + index + ", root(" + index + ") : " + node.val + ", left(" + (2 * index + 1) + ") : " + node.left.val + ", right(" + (2 * index + 2) + ") : " + node.right.val);
            makeTree(nums, 2 * index + 1, left);
            makeTree(nums, 2 * index + 2, right);
        }
    }
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        int[] nums = {1, 0, 1, 0, 1, 0, 1};
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<nums.length ; i++) {
            queue.add(nums[i]);
        }

        Q1022 q = new Q1022();
        TreeNode rootNode = new TreeNode();
        Search search = new Search();
        search.makeTree(nums, 0, rootNode);
//        search.bfs(rootNode);
//        search.dfs(rootNode);
        q.sumRootToLeaf(rootNode);
    }

    public int sumRootToLeaf(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(root, 0);
        stack.push(pair);

        int result = 0;
        int current = 0;
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode r = p.getNode();
            current = p.getValue();
            if(r != null) {
                System.out.println("current : " + Integer.toBinaryString(current) + ", r.val : " + r.val);
                current = current << 1 | r.val;
                if (r.left == null && r.right == null) {
                    result += current;
                } else {
                    stack.push(new Pair(r.left, current));
                    stack.push(new Pair(r.right, current));
                }
                System.out.println("current : " + Integer.toBinaryString(current));
            }
        }
        System.out.println("result : " + result);
        return result;
    }
}
















