/*
Count Subarrays With Score Less Than K
The score of an array is defined as the product of its sum and its length.

        For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.

        Example 1:

Input: nums = [2,1,4,3,5], k = 10
Output: 6
Explanation:
The 6 subarrays having scores less than 10 are:
        - [2] with score 2 * 1 = 2.
        - [1] with score 1 * 1 = 1.
        - [4] with score 4 * 1 = 4.
        - [3] with score 3 * 1 = 3.
        - [5] with score 5 * 1 = 5.
        - [2,1] with score (2 + 1) * 2 = 6.
Note that subarrays such as [1,4] and [4,3,5] are not considered because their scores are 10 and 36 respectively, while we need scores strictly less than 10.
*/

//Approach 1 -Sliding Window
public long countSubarrays(int[] nums, long k) {
    long count = 0;
    long sum = 0;
    for (int start = 0, end = 0; end < nums.length; end++) {
        sum += nums[end];
        while (sum * (end - start + 1) >= k) {
            sum -= nums[start];
            start++;
        }

        count += end - start + 1;
    }
    return count;
}
