class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return recursion(n, memo);
    }

    private int recursion(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
        return memo[n];
    }
}