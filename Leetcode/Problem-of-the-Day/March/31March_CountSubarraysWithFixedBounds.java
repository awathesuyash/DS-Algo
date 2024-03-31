/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.



        Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].*/

//Approach 1: Brute-force TLE
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        long minPos, maxPos;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            minPos = Integer.MAX_VALUE;
            maxPos = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                minPos = Math.min(minPos, nums[j]);
                maxPos = Math.max(maxPos, nums[j]);

                if (minPos == minK && maxPos == maxK)
                    ans++;
            }
        }
        return ans;

    }
}

//Approach 2
public long countSubarrays(int[] nums, int minK, int maxK) {
    long minPos = -1, maxPos = -1, wrongIndex = -1;
    long ans = 0;
    for (int i = 0; i < nums.length; i++) {

        if (nums[i] < minK || nums[i] > maxK)
            wrongIndex = i;
        if (nums[i] == minK)
            minPos = i;
        if (nums[i] == maxK)
            maxPos = i;
        long smallerIndx = Math.min(minPos, maxPos);
        long temp = smallerIndx - wrongIndex;
        ans += Math.max(0, temp);
    }
    return ans;
}