class Solution {
    public int findPeakElement(int[] nums) {
        int res = -1;
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            
            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                res = mid;       
                high = mid - 1;  
            }
        }
        
        return res;
    }
}