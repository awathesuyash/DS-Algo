/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



        Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

//Approach 5: Unique Best Appraoch -Binary Search

public int[] findExactIndex(int firstNum, int secNum, int[] exact) {
    int[] index = new int[2];
    int n = exact.length;
    for (int i = 0; i < n; i++) {
        if (exact[i] == firstNum) {
            index[0] = i;
            break;
        }
    }
    for (int i = 0; i < n; i++) {
        if (exact[i] == secNum)
            index[1] = i;
    }
    Arrays.sort(index);
    return index;
}

public int[] twoSum(int[] nums, int target) {

    int[] exact = new int[nums.length];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        exact[i] = nums[i];
    }

    Arrays.sort(nums);
    // Search target-nums[i] in sorted array -Binary Searh
    // Search Each element

    int[] index = new int[2];
    int l = 0, r = n - 1;
    for (int i = 0; i < n; i++) {
        int search = target - nums[i];
        l = i + 1;
        r = n - 1;

        // Binary Search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < search) {
                l = mid + 1;
            } else if (nums[mid] > search) {
                r = mid - 1;
            } else {

                // As Element is Found,find indexs in exactArray
                index = findExactIndex(nums[mid], nums[i], exact);
                return index;
                // int[] index=new int[2];
                // int n=exact.length;

            }
        }

    }
    return new int[2];
}

//Approach 1: ButeForce
public int[] twoSum(int[] nums, int target) {

    int[] ans = new int[2];
    int n = nums.length;
    int k = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (nums[i] + nums[j] == target && i != j) {
                ans[k] = i;
                ans[k + 1] = j;
            }

        }
    }

    return ans;
}

//Approach 2: Brute Force --list
public int[] twoSum(int[] nums, int target) {

    List<Integer> list=new ArrayList<>();
    // int[] ans = new int[2];
    int n = nums.length;
    int k = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            if (nums[i] + nums[j] == target ) {
                // ans[k] = i;
                // ans[k + 1] = j;
                list.add(i);
                list.add(j);
            }

        }
    }
    // Integer ans=new Integer
    return list.stream().mapToInt(Integer::intValue).toArray();
    //return ans;
}

//Appraoch 3: Map :2 Pass
public int[] twoSum(int[] nums, int target) {

    HashMap<Integer,Integer>map=new HashMap<>();
    for(int i=0;i<nums.length;i++)
    {
        map.put(nums[i],i);
    }
    for(int i=0;i<nums.length;i++)
    {
        int element=target-nums[i];
        if(map.containsKey(element) && map.get(element)!=i)
        {
            return new int []{i,map.get(element)};
        }
    }

    return new int[]{};
}

//Approach 4: Map: 1 Pass
public int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int element = target - nums[i];
        if (map.containsKey(element) ) {
            return new int[] { i, map.get(element) };
        }
        map.put(nums[i],i);
    }

    return new int[] {};
}

