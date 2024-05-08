//https://leetcode.com/problems/coin-change/description/
/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0*/



//Approach : Tablutation

public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];

    if (n == 1 && amount % coins[0] != 0)
        return -1;

    for (int j = 0; j <= amount; j++)
        dp[0][j] = Integer.MAX_VALUE - 1;
    for (int i = 0; i <= n; i++)
        dp[i][0] = 0;

    for (int i = 1, j = 1; j <= amount; j++) {
        if (j % coins[0] == 0)
            dp[i][j] = j / coins[0];
        else
            dp[i][j] = Integer.MAX_VALUE - 1;
    }

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= amount; j++) {
            if (coins[i - 1] <= j) {
                dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
            } else
                dp[i][j] = dp[i - 1][j];
        }
    }

    if (dp[n][amount] < Integer.MAX_VALUE-1)
        return dp[n][amount];
    else
        return -1;
}