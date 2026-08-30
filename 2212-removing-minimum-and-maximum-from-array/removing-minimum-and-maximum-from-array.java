class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return n;
        int minIdx = 0;
        int maxIdx = 0;
        for(int i=1;i<n;i++){
            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
        }

        int ans = Integer.MAX_VALUE;

        int min = 0, max = 0;
        if(minIdx < maxIdx){
            min = minIdx;
            max = maxIdx;
        }else{
            min = maxIdx;
            max = minIdx;
        }

        //first case remove from front
        ans = Math.min(ans,max + 1);

        //2nd case remove from back
        ans = Math.min(ans,n-min);

        //3rd case from both side
        ans = Math.min(ans,min+1 + n-max);

        return ans;
    }
}