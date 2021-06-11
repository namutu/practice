package study;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PostOrder {
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
        Integer[] tree = {3,9,20,null,null,15,7};
        int[] preOrder = {3,9,20,15,7};
        int[] postOrder = {7,20,15,3,9};

        TreeNode root = new TreeNode();
        makeTree(tree, 0, root);

        TreeNode result =  makeNewTree(preOrder, postOrder);

//        dfs(root);
//        System.out.println();
//        dfs(result);
        bfs(root);
        System.out.println();
        bfs(result);

    }
    static void dfs(TreeNode root) {
        System.out.print(root.val + " ");
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);
    }
    static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            System.out.print(r.val + " ");
            if(r.left != null) queue.add(r.left);
            if(r.right != null) queue.add(r.right);
        }
    }
    static Map<Integer, Integer> preorderIndex = new HashMap<>();
    static int postOrderIndex = 0;
    public static TreeNode makeNewTree(int[] preorder, int[] postorder) {

        for(int i=0 ; i<preorder.length ; i++) {
            preorderIndex.put(preorder[i], i);
        }

        TreeNode result = setNewTree(postorder, 0, preorder.length-1);

        return result;
    }

    public static TreeNode setNewTree(int[] postOrder, int left, int right) {
        if(right<left) return null;

        int rootValue = postOrder[postOrderIndex];
        postOrderIndex++;
        TreeNode root = new TreeNode();
        root.val = rootValue;

        root.right = setNewTree(postOrder, preorderIndex.get(rootValue)+1, right);
        root.left = setNewTree(postOrder, left, preorderIndex.get(rootValue)-1);

        return root;
    }
}
















