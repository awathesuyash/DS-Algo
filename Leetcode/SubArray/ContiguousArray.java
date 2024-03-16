/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.*/

public int findMaxLength(int[] nums) {
    HashMap<Integer,Integer>map=new HashMap<>();
    int currSum=0,maxlen=0;
    int n=nums.length;

    map.put(0,-1);
    for(int i=0;i<n;i++)
    {
        currSum+= nums[i]==0?-1:1;

        if(map.containsKey(currSum))
        {
            maxlen=Math.max(maxlen,i-map.get(currSum));
        }else{
            map.put(currSum,i);
        }
    }
    return maxlen;
}
