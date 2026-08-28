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
    public int count(TreeNode root){
        if(root == null) return 0;

        return 1 + count(root.left) + count(root.right);
    }

    public boolean solve(TreeNode root,int i, int totalCount){
        if(root == null) return true;
        if(i > totalCount) return false;

        return solve(root.left,2*i,totalCount) &&
               solve(root.right,2*i+1,totalCount);
    }
    
    public boolean isCompleteTree(TreeNode root) {
        int totalCount = count(root);
        int i=1;
        return solve(root,i,totalCount);
    }
}