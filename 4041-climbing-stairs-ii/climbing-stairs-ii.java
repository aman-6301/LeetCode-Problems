class Solution {
    public int climbStairs(int n, int[] costs) {

        int prev3 = 0;
        int prev2 = costs[0] + 1;

        if (n == 1)
            return prev2;

        int prev1 = Math.min(
            costs[1] + 4,
            prev2 + costs[1] + 1
        );

        for (int i = 3; i <= n; i++) {

            int oneStep = prev1 + costs[i - 1] + 1;

            int twoStep = prev2 + costs[i - 1] + 4;

            int threeStep = prev3 + costs[i - 1] + 9;

            int curr = Math.min(
                oneStep,
                Math.min(twoStep, threeStep)
            );

            prev3 = prev2;
            prev2= prev1;
            prev1 = curr;
        }

        return prev1;
    }
}