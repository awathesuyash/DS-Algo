/*
You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.*/

// Approach : Didn't work :
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key:map.keySet())
        {
            int count=Math.min(k,map.get(key));
            while(count!=0)
            {
                list.add(key);
                count--;
            }
        }

        return list.size();
    }
}


// Approach : HashMap + SlidingWIndow
public int maxSubarrayLength(int[] nums, int k) {

    int n = nums.length;
    int maxlength = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    // 1 2 3 1 2 3 1 2
    for (int start = 0, end = 0; end < n; end++) {
        map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

        while (map.get(nums[end]) > k) {
            map.put(nums[start], map.get(nums[start]) - 1);
            start++;
        }

        maxlength = Math.max(maxlength, end - start + 1);
    }
    return maxlength;
}