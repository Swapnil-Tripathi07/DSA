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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] flag = new boolean[1];
        flag[0] = true;  // ✅ initialize properly
        isSameTree(p, q, flag);
        return flag[0];
    }

    public void isSameTree(TreeNode node1, TreeNode node2, boolean[] flag) {
        if (!flag[0]) return; // ✅ stop early

        if (node1 == null && node2 == null) return;

        if (node1 == null || node2 == null || node1.val != node2.val) {
            flag[0] = false;
            return;
        }

        isSameTree(node1.left, node2.left, flag);
        isSameTree(node1.right, node2.right, flag);
    }
}