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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(root,targetSum,res,path);
        return res;
    }

    public void solve(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
        if(root == null) return;

        path.add(root.val);

        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                res.add(new ArrayList<>(path));
            }

            path.remove(path.size()-1);

            return;
        }

        int remSum = targetSum - root.val;

        solve(root.left,remSum,res,path);
        solve(root.right,remSum,res,path);

        path.remove(path.size()-1);
    }
}