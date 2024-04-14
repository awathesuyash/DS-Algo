/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */

//Approach1 : Two Pointer
public int trap(int[] height) {

    int n=height.length;
    //leftMax

    int[] lMax=new int[n];
    int[] rMax=new int[n];

    lMax[0]=height[0];
    for(int i=1;i<n;i++)
    {
        lMax[i]=Math.max(lMax[i-1],height[i]);
    }

    rMax[n-1]=height[n-1];
    for(int i=n-2;i>=0;i--)
    {
        rMax[i]=Math.max(rMax[i+1],height[i]);
    }

    //Find Trapped water - min(lMax,rMax) -height[i];
    int trappedWater=0;
    for(int i=0;i<n;i++)
    {
        int waterLevel=Math.min(lMax[i],rMax[i]);
        trappedWater+=waterLevel -height[i];
    }

    return trappedWater;
}
//Approach 2: Monotonic Way

public int trap(int[] height) {
    int n = height.length;
    // Find & Update leftMax and rightMax
    int lMax = height[0], rMax = height[n - 1];
    int waterLevel = 0;
    int left = 1, right = n - 2;
    //height = [0,1,0,2,1,0,1,3,2,1,2,1]
    while (left <= right) {
        // If leftMax/rightMax is less than height ,then update both
        if (height[left] >= lMax) {
            lMax = height[left];
            left++;
        } else if (height[right] >= rMax) {
            rMax = height[right];
            right--;
        }
        // Then ,if leftMax/rightMax is greater ,then calculate trapped waterLevel
        else if (lMax <= rMax && lMax > height[left]) {
            waterLevel += lMax - height[left];
            left++;
        } else {
            waterLevel += rMax - height[right];
            right--;
        }
    }
    return waterLevel;
}