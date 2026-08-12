class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return recursion(m - 1, n - 1, dp);
    }

    public int recursion(int r, int c, int[][] dp) {
        if (r == 0 || c == 0) return 1;
        if (dp[r][c] != 0) return dp[r][c];

        dp[r][c] = recursion(r - 1, c, dp) + recursion(r, c - 1, dp);
        return dp[r][c];
    }
}