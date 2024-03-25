/*Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



        Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6*/



// Approach

class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        int maxProd=Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            int case1=nums[0]*nums[1]*nums[n-1];
            int case2=nums[n-1]*nums[n-2]*nums[n-3];

            maxProd=Math.max(case1,case2);
        }
        return maxProd;
    }
}
// Approach 2
public int maximumProduct(int[] nums) {
    int n = nums.length;
    int maxProd = Integer.MIN_VALUE;

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
        if (max1 < nums[i]) {
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
        } else if (max2 < nums[i]) {
            max3 = max2;
            max2 = nums[i];
        } else if (max3 < nums[i]) {
            max3 = nums[i];
        }

        if (min1 > nums[i]) {
            min2 = min1;
            min1 = nums[i];
        } else if (min2 > nums[i]) {
            min2 = nums[i];
        }
    }
    maxProd = Math.max(min1 * min2 * max1, max1 * max2 * max3);
    return maxProd;
}