/*
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.



        Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].*/


//Approach Sliding WIndow:
public long countSubarrays(int[] nums, int k) {
    int n = nums.length;
    // findMax
    int maxNum = nums[0];
    for (int i = 0; i < n; i++) {
        maxNum = Math.max(maxNum, nums[i]);
    }

    // Sliding Window
    int count = 0;
    long ans = 0;
    for (int start = 0, end = 0; end < n; end++) {
        if (nums[end] == maxNum)
            count++;

        while (count >= k) {
            if (nums[start] == maxNum)
                count--;
            start++;
            ans += nums.length - end;
        }
    }
    return ans;

}

//Approach 2: Non-Sliding WIndow
public long countSubarrays(int[] nums, int k) {
    int n = nums.length;
    // findMax
    int maxNum = nums[0];
    for (int i = 0; i < n; i++) {
        maxNum = Math.max(maxNum, nums[i]);
    }

    //
    int count = 0;
    long ans = 0;
    List<Integer> maxIndices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (nums[i] == maxNum)
            maxIndices.add(i);

        int sizeMaxIndices = maxIndices.size();

        if (sizeMaxIndices >= k) {
            int lastIndx = maxIndices.get(sizeMaxIndices - k);
            ans += lastIndx + 1;
        }
    }
    return ans;

}