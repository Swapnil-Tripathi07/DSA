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
    public int countNodes(TreeNode root) {
        int[] count = new int[1];
        countNodes(root,count);
        return count[0];
    }

    public void countNodes(TreeNode node , int[] count){
        if(node == null){
            return;
        }
        if(node!=null){
            count[0]++;
        }
        countNodes(node.left , count);
        countNodes(node.right , count);
    }
}