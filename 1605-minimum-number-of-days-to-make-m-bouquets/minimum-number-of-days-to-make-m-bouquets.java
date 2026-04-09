class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m*k) return -1;
        int maxDay = Integer.MIN_VALUE;
        for(int day: bloomDay){
            maxDay = Math.max(day, maxDay);
        }

        int low = 1, high = maxDay;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] bloomDay, int mid, int m, int k){
    int count = 0;
    int bouquets = 0;

    for(int day : bloomDay){
        if(day <= mid){
            count++;
        } else {
            bouquets += count / k;
            count = 0;
        }
    }

    
    bouquets += count / k;

    return bouquets >= m;
}
}