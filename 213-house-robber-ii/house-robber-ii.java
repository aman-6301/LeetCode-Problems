class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i=0; i<n-1; i++){
            temp1[i] = nums[i];
        }

        for(int i=1; i<n; i++){
            temp2[i-1] = nums[i];
        }

        return Math.max(find(temp1), find(temp2));
    }

    public int find(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int take = nums[i];

            if(i>1){
                take += dp[i-2];
            }
                
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }
}