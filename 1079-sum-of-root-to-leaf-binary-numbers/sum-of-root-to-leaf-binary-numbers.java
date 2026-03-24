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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[1];
        String s = "";
        sumRootToLeaf(root,s,sum);
        return sum[0];
        
    }
    public void sumRootToLeaf(TreeNode node , String s,int[] sum){
        if(node == null){
            return;
        }
        // if(node == root){
        //     s = "";
        //     s = s + node.val;
        // }
        if(node != null){
            s = s + node.val;
        }
        if(node.left == null && node.right == null){
            sum[0] += Integer.parseInt(s,2);
        }
        sumRootToLeaf(node.left , s , sum);
        sumRootToLeaf(node.right , s , sum);
    }
}