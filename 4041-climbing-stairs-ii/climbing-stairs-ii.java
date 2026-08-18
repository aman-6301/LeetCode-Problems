class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        dp[0] = 0;

        dp[1] = costs[0] + 1;

        if (n == 1)
            return dp[1];

        dp[2] = Math.min(
            costs[1] + 4,
            dp[1] + costs[1] + 1
        );

        for (int i = 3; i <= n; i++) {

            int oneStep = dp[i - 1] + costs[i - 1] + 1;

            int twoStep = dp[i - 2] + costs[i - 1] + 4;

            int threeStep = dp[i - 3] + costs[i - 1] + 9;

            dp[i] = Math.min(
                oneStep,
                Math.min(twoStep, threeStep)
            );
        }

        return dp[n];
    }
}