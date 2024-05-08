/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



        Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
        - Pay 15 and climb two steps to reach the top.
The total cost is 15.*/

//Approach1 : Recurssion TLE
// Recursive Top Down - O(2^n) Time Limit Exceeded
public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
    if (n < 0) return 0;
    if (n==0 || n==1) return cost[n];
    return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
}

// Approach 2: Top-Down Memoization
int[] dp;

public int minCost(int[] cost, int n) {
    if (n < 0)
        return 0;
    if (n == 0 || n == 1)
        return cost[n];

    if (dp[n] != 0)
        return dp[n];
    dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    return dp[n];
}

public int minCostClimbingStairs(int[] cost) {
    // Input: cost = [10,15,20]
    // Output: 15
    int n = cost.length;
    dp = new int[n];
    return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
}

//Approach3 : Bottom -Up -Optimization
int[] dp;
public int minCostClimbingStairs(int[] cost) {
    // Input: cost = [10,15,20]
    // Output: 15
    int n = cost.length;
    dp = new int[n];

    dp[0] = cost[0];
    dp[1] = cost[1];

    for (int i = 2; i < n; i++) {
        dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }
    return Math.min(dp[n - 1], dp[n - 2]);
}

//Approach 4 : Fine Tunning : O(n) - O(1)
public int minCostClimbingStairs(int[] cost) {
    // Input: cost = [10,15,20]
    // Output: 15
    int n = cost.length;
    int first=cost[0];
    int second=cost[1];

    for(int i=2;i<n;i++)
    {
        int curr=cost[i]+ Math.min(first,second);
        first=second;
        second=curr;
    }
    return Math.min(first,second);
}
