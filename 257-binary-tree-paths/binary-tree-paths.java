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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, "", result);
        return result;
    }
    
    public void helper(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        
        // Add current node to path
        if (path.length() == 0) {
            path = "" + node.val;
        } else {
            path = path + "->" + node.val;
        }
        
        // If leaf node → add to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        
        // Traverse left & right
        helper(node.left, path, result);
        helper(node.right, path, result);
    }
}