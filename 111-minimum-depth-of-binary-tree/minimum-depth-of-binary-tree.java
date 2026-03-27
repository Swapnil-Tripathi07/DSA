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
    public int minDepth(TreeNode root) {
        int[] detail = new int[3];
        minDepth(root,detail);
        return detail[1];
    }
    public void minDepth(TreeNode node , int[] detail){
        if(node == null){
            return;
        }
        detail[0]++;

        if(node.left==null && node.right==null){
            detail[2]++;    //countNode
            if(detail[2]==1){
                detail[1] = detail[0];  //min and count.
            }
            if(detail[0]<detail[1]){
                detail[1] = detail[0];
            }
        }
        
        minDepth(node.left,detail);
        minDepth(node.right,detail);
        detail[0]--;
    }
}