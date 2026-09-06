class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return solve(s,t,0,0,dp);
    }

    public int solve(String s, String t, int i, int j, int[][] dp){
        if (j == t.length()) return 1;

        if (i == s.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int count = solve(s, t, i + 1, j,dp);
        if (s.charAt(i) == t.charAt(j)) {
            count += solve(s, t, i + 1, j + 1,dp);
        }

        return dp[i][j] = count;
    }
}