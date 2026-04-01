/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;
    private int maxCount = 0;
    private TreeNode prev = null;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // process current node
        if (prev != null && prev.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        prev = root;

        inorder(root.right);
    }
}