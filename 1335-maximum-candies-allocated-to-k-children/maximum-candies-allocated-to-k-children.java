class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 10_000_000;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long Count = 0;

            for (int candy : candies) {
                Count += candy / mid;
            }

            if (Count >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
