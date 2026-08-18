class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, costs, dp);
    }

    public int solve(int n, int[] costs, int[] dp) {

        // We are already at the starting stair
        if (n == 0)
            return 0;

        // For stair 1, only 0 -> 1 is possible
        if (n == 1)
            return costs[0] + 1;

        // For stair 2, we can come from 0 or 1
        if (n == 2) {
            int from0 = costs[1] + 4;
            int from1 = solve(1, costs,dp) + costs[1] + 1;

            return Math.min(from0, from1);
        }

        if(dp[n] != -1) return dp[n];

        int oneStep = solve(n - 1, costs,dp) + costs[n - 1] + 1;
        int twoStep = solve(n - 2, costs,dp) + costs[n - 1] + 4;
        int threeStep = solve(n - 3, costs,dp) + costs[n - 1] + 9;

        return dp[n] = Math.min(oneStep, Math.min(twoStep, threeStep));
    }
}