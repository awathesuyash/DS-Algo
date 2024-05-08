

//https://leetcode.com/problems/partition-equal-subset-sum/description/

//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
//
//Example 1:
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Approach 1: Top-Down Approach

public boolean isSubsetPossible(int[] nums, int sum) {
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= sum; j++) {
            if (i == 0)
                dp[i][j] = false;
            if (j == 0)
                dp[i][j] = true;
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            if (nums[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            } else
                dp[i][j] = dp[i - 1][j];
        }
    }

    return dp[n][sum];
}

public boolean canPartition(int[] nums) {

    int sum = 0;
    for (int x : nums)
        sum += x;

    if (sum % 2 != 0)
        return false;

    return isSubsetPossible(nums, sum / 2);

}