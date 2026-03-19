class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int target) {
        int beg = 0, end = nums.length - 1, ans = -1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1; 
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public int findLast(int[] nums, int target) {
        int beg = 0, end = nums.length - 1, ans = -1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] == target) {
                ans = mid;
                beg = mid + 1; 
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
