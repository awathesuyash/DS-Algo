//https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

Example 1:

Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
*/

// Approach : Memoization

public long count(int coins[], int N, int sum) {
    long[][] dp=new long[N+1][sum+1];
    for(long[] row:dp)
        Arrays.fill(row,-1);
    return solvecount( coins, N,sum,dp);
}
public long solvecount(int coins[], int N, int sum,long[][] dp) {

    if(sum==0) return 1;
    if(sum < 0 || N <=0) return 0;

    if(dp[N][sum]!=-1) return dp[N][sum];

    if(coins[N-1]<=sum)
    {
        return dp[N][sum]= solvecount( coins, N-1,sum,dp) + solvecount( coins, N,sum-coins[N-1],dp) ;
    }
    else  return dp[N][sum]= solvecount( coins, N-1,sum,dp) ;
}

//Approach : Tabulation BottomUp
public long count(int coins[], int N, int sum) {
    long[][]dp=new long[N+1][sum+1];

    for(int j=0;j<=sum;j++) dp[0][j]=0;
    for(int i=0;i<=N;i++) dp[i][0]=1;

    for(int i=1;i<=N;i++)
    {
        for(int j=1;j<=sum;j++)
        {
            if(coins[i-1]<=j)
            {
                dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];
            }
            else dp[i][j]=dp[i-1][j];
        }
    }
    return dp[N][sum];

}
