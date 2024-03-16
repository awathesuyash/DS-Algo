// BruteForce --TLE 

public int numSubarraysWithSum(int[] nums, int goal) {
    // [1,0,1,0,1]
    int sum, count = 0;
    for (int i = 0; i < nums.length; i++) {
        sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (sum == goal)
                count++;
        }
    }
    return count;
}
// Approach 1 --HashMap

public int numSubarraysWithSum(int[] nums, int goal) {
    // [1,0,1,0,1]
    int preSum = 0, count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
        preSum += nums[i];
        int remove = preSum - goal;
        if (map.containsKey(remove)) {
            count += map.get(remove);
        }
        map.put(preSum, map.getOrDafault(preSum, 0) + 1);
    }
    return count;
}



