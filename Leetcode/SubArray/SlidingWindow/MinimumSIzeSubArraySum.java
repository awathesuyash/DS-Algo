/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.*/


public int minSubArrayLen(int target, int[] nums) {

    int n = nums.length;
    int count = Integer.MAX_VALUE, sum = 0;
    for (int start = 0, end = 0; end < n; end++) {
        sum += nums[end];
        while (sum >= target) {
            count = Math.min(count, end - start + 1);
            sum = sum - nums[start++];
        }
    }

    return count == Integer.MAX_VALUE ? 0 : count;
}
