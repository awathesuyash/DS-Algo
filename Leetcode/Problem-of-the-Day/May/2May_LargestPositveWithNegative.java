//Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
//
//Return the positive integer k. If there is no such integer, return -1.
//
//
//
//Example 1:
//
//Input: nums = [-1,2,-3,3]
//Output: 3
//Explanation: 3 is the only valid k we can find in the array.\

// Apprroach 2: Two pointer

public int findMaxK(int[] nums) {

    Arrays.sort(nums);
    int start = 0, end = nums.length-1;

    while (start < end) {
        if ((nums[start] + nums[end]) == 0)
            return nums[end];
        else if ((nums[start] + nums[end]) < 0)
            start++;
        else
            end--;
    }
    return -1;

}

//HashSet :

public int findMaxK(int[] nums) {
    // Input: nums = [-1,2,-3,3]
    // Output: 3

    Set<Integer> set = new HashSet<>();
    int ans = -1;
    for (int x : nums) {
        set.add(x);
        int k = -1 * x;
        if (set.contains(k)) {
            ans = Math.max(ans, Math.abs(x));
        }
    }
    return ans;

}