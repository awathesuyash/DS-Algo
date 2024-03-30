/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



        Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]*/


//Apprroach 1: Sliding Window (2 Pass )

class Solution {
    // COunt of Subarray with <=k Distinct Element
    public int slidingWindow(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < nums.length; end++) {

            map.put(nums[end],
                    map.getOrDefault(nums[end], 0) + 1);

            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0)
                    map.remove(nums[start]);
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // Sliding Window
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }
}


//Approach 2: i-iBada : OnePass Slding Window

public int subarraysWithKDistinct(int[] nums, int k) {
    // Sliding Window

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0, n = nums.length;
    int result = 0;
    int initIndex = 0; // i_Bada --to find start of valid subarray
    for (int start = 0, end = 0; end < n; end++) {
        map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

        // For Invalid Subarray shrink window gradually
        while (map.size() > k) {
            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0)
                map.remove(nums[start]);
            start++;
            initIndex = start;
        }

        // Find Smallest Valid Subarray
        while (map.get(nums[start]) > 1) {
            map.put(nums[start], map.get(nums[start]) - 1);
            start++;
        }
        if(map.size()==k)
            result += (start - initIndex + 1);
    }
    return result;

}