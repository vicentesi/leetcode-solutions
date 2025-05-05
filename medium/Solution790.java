class Solution790 {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        long a = 1;
        long b = 2;
        long c = 5;
        long d = 0;

        for (int i = 4; i <= n; i++) {
            d = (2 * c % MOD + a) % MOD;
            a = b;
            b = c;
            c = d;
        }

        return (int) d;
    }

    /*
     * public int numTilings(int n) {
     * int MOD = 1_000_000_007;
     * if (n == 1) return 1;
     * if (n == 2) return 2;
     * if (n == 3) return 5;
     * 
     * long[] dp = new long[n + 1];
     * dp[0] = 1;
     * dp[1] = 1;
     * dp[2] = 2;
     * dp[3] = 5;
     * 
     * for (int i = 4; i <= n; i++) {
     * dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
     * }
     * 
     * return (int) dp[n];
     * }
     */
}

/*
 * 790. Domino and Tromino Tiling
 * 
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You
 * may rotate these shapes.
 * 
 * 
 * Given an integer n, return the number of ways to tile an 2 x n board. Since
 * the answer may be very large, return it modulo 109 + 7.
 * 
 * In a tiling, every square must be covered by a tile. Two tilings are
 * different if and only if there are two 4-directionally adjacent cells on the
 * board such that exactly one of the tilings has both squares occupied by a
 * tile.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 5
 * Explanation: The five different ways are show above.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 */
