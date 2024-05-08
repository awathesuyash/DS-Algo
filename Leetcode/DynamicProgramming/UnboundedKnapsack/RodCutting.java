/*
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
        22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and
6, i.e., 5+17=22.
*/

//Approach : Tablution (Bottom-up)
public int cutRod(int price[], int n) {
    //code here
    //  int len=price.length;
    int[] len=new int[n];
    for(int i=0;i<n;i++) len[i]=i+1;

    int[][]dp=new int[n+1][n+1];

    for(int i=0;i<=price.length;i++)
    {
        for(int j=0;j<=n;j++)
        {
            if(i==0)dp[i][j]=0;
            if(j==0)dp[i][j]=0;
        }
    }
    for(int i=1;i<=price.length;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(len[i-1]<=j)
                dp[i][j]=Math.max(price[i-1]+dp[i][j-len[i-1]], dp[i-1][j]);
            else
                dp[i][j]=dp[i-1][j];
        }
    }
    return dp[n][n];
}