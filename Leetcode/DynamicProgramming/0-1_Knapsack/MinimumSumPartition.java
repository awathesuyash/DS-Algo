// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
//Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference
//
//
//Example 1:
//
//Input: N = 4, arr[] = {1, 6, 11, 5}
//Output: 1
//Explanation:
//Subset1 = {1, 5, 6}, sum of Subset1 = 12
//Subset2 = {11}, sum of Subset2 = 11

// Approach : Top-Down


public int subsetSum(int[] arr,int sum){

    int n=arr.length;
    boolean[][] dp=new boolean[n+1][sum+1];

    for(int i=0;i<=n;i++)
    {
        for(int j=0;j<=sum;j++){
            if(i==0) dp[i][j]=false;
            if(j==0) dp[i][j]=true;
        }
    }

    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=sum;j++){
            if(arr[i-1] <=j)
            {
                dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
            else
                dp[i][j]=dp[i-1][j];
        }
    }

    List<Integer> validElement=new ArrayList<>();

    for(int i=n,j=0;j<=sum/2;j++)
    {
        if(dp[i][j]==true)
            validElement.add(j);
    }

    //Find Min Diff
    int minDiff=Integer.MAX_VALUE;
    for(int i=0;i<validElement.size();i++)
    {
        minDiff=Math.min(minDiff, sum-2*validElement.get(i));
    }
    return minDiff;

}
public int minDifference(int arr[], int n)
{
    // Find Range :Sum
    int range=0;
    for(int x:arr) range+=x; // 23

    return subsetSum(arr,range);

}