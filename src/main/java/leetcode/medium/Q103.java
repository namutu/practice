package leetcode.medium;

import java.util.*;


public class Q103 {
    static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       public TreeNode() { }
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }
    static class NodePair {
        TreeNode node;
        int level;
    }
    public static void main(String[] args) {
//        Integer[] nums = {3,9,20,null,null,15,7};
//        Integer[] nums = {1,2,3,4,5};
        Integer[] nums = {0,2,4,1,null,3,-1,5,1,null,6,null,8};

        TreeNode root = new TreeNode();
        makeTree(nums, 0, root);

        List<List<Integer>> result = zigzagLevelOrder(root);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        NodePair p = new NodePair();
        p.node = root;
        p.level = 0;
        bfs(p, result);
        System.out.println("result : " + result.toString());
        return result;
    }
    static void bfs(NodePair root, List<List<Integer>> result) {
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.node.val);
        result.add(rootList);
        Queue<NodePair> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            NodePair p = queue.poll();
            TreeNode n = p.node;
            int level = p.level+1;

            if(n.left != null || n.right != null) {
                List<Integer> subList;
                try {
                    subList = result.get(level);
                } catch (IndexOutOfBoundsException e) {
                    subList = new ArrayList<>();
                    result.add(subList);
                }
                if (n.left != null) {
                    subList.add(n.left.val);
                    NodePair np = new NodePair();
                    np.level = level;
                    np.node = n.left;
                    queue.add(np);
                }
                if (n.right != null) {
                    subList.add(n.right.val);
                    NodePair np = new NodePair();
                    np.level = level;
                    np.node = n.right;
                    queue.add(np);
                }
                if (level % 2 != 0) {
                    System.out.println("level : " + level);
                    System.out.println(subList.toString());
                    Collections.sort(subList, Collections.reverseOrder());
                }
            }
        }
    }
    public static void makeTree(Integer[] nums, int index, TreeNode root) {
        if(index>=nums.length) return;
        System.out.println("index : " + index + ", root : " + nums[index].intValue());
        root.val = nums[index].intValue();
        if(2*index+1 < nums.length && nums[2*index+1] != null) {
            TreeNode left = new TreeNode(nums[2*index+1].intValue());
            root.left = left;
            makeTree(nums, 2*index+1, left);
        }
        if(2*index+2 < nums.length && nums[2*index+2] != null) {
            TreeNode right = new TreeNode(nums[2*index+2].intValue());
            root.right = right;
            makeTree(nums, 2*index+2, right);
        }
    }
}
