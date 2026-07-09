class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return find(n-1,nums,dp);
    }

    public int find(int idx, int[] nums, int[] dp){
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + find(idx-2,nums,dp);

        int notTake = find(idx-1,nums,dp);

        return dp[idx] = Math.max(take, notTake);
    }
}