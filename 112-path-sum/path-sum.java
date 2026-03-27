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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int[] check = new int[1];
        boolean[] flag = new boolean[1];
        hasPathSum(root,targetSum,check,flag);
        return flag[0];
    }
    public void hasPathSum(TreeNode node,int targetSum,int[] check,boolean[] flag){
        if(node==null || flag[0]){
            return;
        }
        if(node==null){
            // flag[0] = false;
            return;
        }
        check[0] = check[0] + node.val;
        if(node.left==null && node.right==null){
            if(check[0]==targetSum){
                flag[0] = true;
                return;
            }
        }
        hasPathSum(node.left,targetSum,check,flag);
        hasPathSum(node.right,targetSum,check,flag);
        check[0] = check[0]-node.val;
    }
}