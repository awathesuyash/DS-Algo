/*
Given an integer array nums, find a
subarray
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

// Approach 1- All SubArray and Check prod (O(n2) )
public int maxProduct(int[] nums) {
    int maxProd;
    int n=nums.length;
    int[] res=new int[n];

    int prod=1;
    maxProd=Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
        prod=1;
        for(int j=i;j<n;j++)
        {
            prod*=nums[j];
            maxProd=Math.max(maxProd,prod);
        }
    }
    return maxProd;

}


// Approach 2 O(n) + O(n)

public int maxProduct(int[] nums) {
    int maxProd;
    int n=nums.length;
    int prod=1;
    maxProd=Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
        if(prod==0) prod=1;

        prod*=nums[i];
        maxProd=Math.max(maxProd,prod);
    }
    prod=1;
    for(int i=n-1;i>=0;i--)
    {
        if(prod==0) prod=1;

        prod*=nums[i];
        maxProd=Math.max(maxProd,prod);
    }
    return maxProd;
}

//// Approach 2 O(n) + O(n)

public int maxProduct(int[] nums) {
    int maxProd;
    int n=nums.length;
    int prefix=1,sufix=1;
    maxProd=Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
        if(prefix==0) prefix=1;
        if(sufix==0) sufix=1;

        prefix*=nums[i];
        sufix*=nums[n-1-i];

        maxProd=Math.max(maxProd,Math.max(sufix,prefix));
    }
    return maxProd;
}