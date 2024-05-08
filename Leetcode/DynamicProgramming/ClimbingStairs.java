//https://leetcode.com/problems/climbing-stairs/description/
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps*/

//Approach1 : Fibonacci Series : TLE
public int climbStairs(int n) {

    // It's Fibonacci Question

    if(n==0 || n==1) return 1;
    return climbStairs(n-1)+climbStairs(n-2);
}

//Approach 2 :  Memoization

public int climbWays(int[] dp, int n) {

    if (n == 0 || n == 1)
        return 1;

    if (dp[n] != -1)
        return dp[n];

    dp[n] = climbWays(dp, n - 1) + climbWays(dp, n - 2);
    return dp[n];
}

public int climbStairs(int n) {
    // It's Fibonacci Question
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);

    return climbWays(dp, n);
}

//Approach 3:   Top-Down Approach
public int climbStairs(int n) {
    // It's Fibonacci Question
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}

// Iterative :
public int climbStairs(int n) {
    // It's Fibonacci Question

    int a = 0;
    int b = 1;
    int c = 0;

    for (int i = 0; i < n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}