/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.*/


//Approach 1: O(n3)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output=new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> set=new HashSet<>();
        //BruteForce
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0 )
                    {
                        //     List<Integer> list=Arrays.asList(nums[i],nums[j],nums[k] );
                        //    // Collections.sort(list);
                        //  list.sort(null);
                        //      set.add(list);
                        set.add(Arrays.asList(nums[i],nums[j],nums[k] ));
                    }
                }
            }
        }
        output.addAll(set);
        // return set.stream().collect(Collectors.toList());
        return output;
    }
}

//Approach 2: O(n2) *log M

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        Set<List<Integer>> finalSet = new HashSet<>(); //Storing Result Triplet
        // Better Code
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> currSet = new HashSet<>(); // Check
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (currSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    finalSet.add(temp);
                }
                currSet.add(nums[j]);
            }
        }
        output.addAll(finalSet);
        // return set.stream().collect(Collectors.toList());
        return output;
    }
}

// Approach : o(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        // Sort Array
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // if not firstELement
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return output;
    }
}