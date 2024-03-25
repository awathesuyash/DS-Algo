/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
*/

// Approach - tempArray
public int findDuplicate(int[] nums) {

    int[]temp=new int[nums.length];

    for(int i=0;i<nums.length;i++)
    {
        if(temp[nums[i]]!=-1)
            temp[nums[i]]=-1;
        else  return nums[i];
    }
    return 0;
}


//-Approach -InArray
public int findDuplicate(int[] nums) {

    for(int i=0;i<nums.length;i++)
    {
        int index=Math.abs(nums[i]);
        if( nums[ index ] < 0 )
            return index;
        else
            nums[index]=-nums[index];
    }
    return nums.length;
}

// FLoyD's algo

public int findDuplicate(int[] nums) {

    int slow = 0;
    int fast = 0;

    while (true) {
        fast = nums[nums[fast]];
        slow = nums[slow];
        if (slow == fast)
            break;
    }

    slow = 0;
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}

