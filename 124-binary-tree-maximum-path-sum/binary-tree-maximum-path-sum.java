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
    int maxSum = Integer.MIN_VALUE;

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int dono_achha = root.val + l + r;

        int koi_ek_achha = Math.max(l, r) + root.val;
        int sirf_root_achha = root.val;

        maxSum = Math.max(maxSum,
                Collections.max(Arrays.asList(dono_achha, koi_ek_achha, sirf_root_achha)));

        return Math.max(koi_ek_achha, sirf_root_achha);
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
}