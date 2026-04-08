class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles=Integer.MIN_VALUE;
        for(int x: piles){
            maxPiles = Math.max(maxPiles,x);
        }

        int l = 1, r = maxPiles;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            long time = calculate(piles,mid);
            
            if(time >h){
                l = mid+1;
            }
            else{
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }

    public static long calculate(int[] piles, int mid){
        long time =0;
        for(int pile : piles){
            time += (pile + mid -1)/mid;
        }
        return time;
    }
}