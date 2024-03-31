/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/

//Approach 3: O(n4)
public List<List<Integer>> fourSum(int[] a, int target) {

    List<List<Integer>> output = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    int n = a.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                for (int l = k + 1; l < n; l++) {

                    long sum = a[i] + a[j];
                    sum += a[k];
                    sum += a[l];

                    if (sum == target) {
                        List<Integer> list = Arrays.asList(a[i], a[j], a[k], a[l]);
                        Collections.sort(list);

                        set.add(list);

                    }
                }
            }
        }
    }
    output.addAll(set);
    return output;
}

// Approach 2: O(n3)
public List<List<Integer>> fourSum(int[] a, int target) {

    Set<List<Integer>> finalSet = new HashSet<>();

    int n = a.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            Set<Long> checkSet = new HashSet<>();

            for (int k = j + 1; k < n; k++) {

                long sum = a[i] + a[j];
                sum += a[k];
                long forth = target - sum;

                if (checkSet.contains(forth)) {
                    List<Integer> list = Arrays.asList(a[i], a[j], a[k], (int) forth);
                    Collections.sort(list);
                    finalSet.add(list);
                }
                checkSet.add((long) a[k]);
            }
        }
    }

    List<List<Integer>> output = new ArrayList<>(finalSet);
    // output.addAll(finalSet);
    return output;
}

//Appraoch 3: Otimized Approach
public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> output = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        // if is not firstElement
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        for (int j = i + 1; j < n; j++) {
            if (j != i + 1 && nums[j] == nums[j - 1])
                continue;
            int k = j + 1;
            int l = n - 1;
            while (k < l) {
                long sum = nums[i] + nums[j];
                sum += nums[k];
                sum += nums[l];
                if (sum < target)
                    k++;
                else if (sum > target)
                    l--;
                else { // sum==target
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                    Collections.sort(list);
                    output.add(list);
                    k++;
                    l--;
                    while (k < l && nums[k] == nums[k - 1])
                        k++;
                    while (k < l && nums[l] == nums[l + 1])
                        l--;
                }
            }
        }
    }
    // output.addAll(finalSet);
    return output;
}
