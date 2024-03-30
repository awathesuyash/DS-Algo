/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0*/


// Approach 1



public int numSubarrayProductLessThanK(int[] nums, int k) {

    int n = nums.length;
    int prod = 1;
    int res = 0;
    for (int i = 0; i < n; i++) {
        prod = 1;
        for (int j = i; j < n; j++) {
            prod *= nums[j]; //
            if (prod < k)
                res++;
            else
                break;
        }
    }
    return res;
}

//Approach 2
public int numSubarrayProductLessThanK(int[] nums, int k) {

    int n = nums.length;
    int prod = 1;
    int count = 0;

    for (int start = 0, end = 0; end < n; end++) {
        prod *= nums[end];
        while (start <= end && prod >= k) {
            prod = prod / nums[start++];
        }
        count += end - start + 1;
    }
    return count;
}