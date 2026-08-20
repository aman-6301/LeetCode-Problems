class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;

        int target = sum/2;

        return solve(nums.length,nums,target);
    }

    public static boolean solve(int n,int[] nums, int target){

        boolean[][] dp = new boolean[n+1][target+1];
       
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                boolean skip = dp[i-1][j];
                boolean take = false;
                if(j >= nums[i-1]){
                    take = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = take || skip;
            }
        }
        return dp[n][target];
    }
}