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
    public int maxDepth(TreeNode root) {
        int[] count = new int[2];
        maxDepth(root,count);
        return count[0];
        
    }
    public void maxDepth(TreeNode node , int[] count){
        if(node==null){
            return;
        }
        if(node!=null){
            count[1]++;
        }
        if(node.left == null && node.right == null){
            count[0] = Math.max(count[0],count[1]);
        }
        maxDepth(node.left,count);
        maxDepth(node.right,count);
        count[1]--;

    }
}