//https://naukri.com/code360/problems/1072980?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM

// DP = Recurrsion + Storage
// DP Identification : Choice + Optimal Solution

// 0-1 KnapSack
// Approach 1: Recurrsion

public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {

    if(n==0|| w==0)
        return 0;

    if(weights.get(n-1) <= w)
    {
        return Math.max(  values.get(n-1) + maxProfit(values, weights, n-1, w-weights.get(n-1)),
                maxProfit(values, weights, n-1, w));
    }
    else return maxProfit(values, weights, n-1, w);
}

// Approach 2: Recurssion + Memoization -- BottomUp

public class Solution {

    public static int knapSack(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w,int[][] dp)
    {
        if(n==0 || w==0) return 0;

        if(dp[n][w] !=-1) return dp[n][w];

        if(weights.get(n-1) <= w)
        {
            dp[n][w]= Math.max( values.get(n-1)+ knapSack(values, weights, n-1, w-weights.get(n-1),dp),
                    knapSack(values, weights, n-1, w,dp));
        }
        else dp[n][w]=knapSack(values, weights, n-1, w,dp);

        return dp[n][w];
    }
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {

        int[][] dp=new int[n+1][w+1];
        //    for(int[] row:dp)
        // 	   Arrays.fill(row,-1);

        Arrays.stream(dp).forEach(  row -> Arrays.fill(row,-1));

        return knapSack(values, weights, n, w,dp);

    }
}

// Approach 3:Top Down

public static int knapSack(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w,int[][] dp)
{
    for(int i=0;i<n+1;i++)
    {
        for(int j=0;j<w+1;j++)
        {
            if(i==0|| j==0)
                dp[i][j]=0;
        }
    }

    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<w+1;j++)
        {
            if(weights.get(i-1) <= j)
                dp[i][j]= Math.max( values.get(i-1)+dp[i-1][j-weights.get(i-1)] , dp[i-1][j] );
            else
                dp[i][j]= dp[i-1][j];
        }
    }

    return dp[n][w];
}
public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {

    int[][] dp=new int[n+1][w+1];
    //    for(int[] row:dp)
    // 	   Arrays.fill(row,-1);

    //	 Arrays.stream(dp).forEach(  row -> Arrays.fill(row,-1));

    return knapSack(values, weights, n, w,dp);

}




