// BruteForce --TLE 

 public int numSubarraysWithSum(int[] nums, int goal) {
      // [1,0,1,0,1]  
        int sum,count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=0;
            for(int j=i;j<nums.length;j++)
            {
               sum+=nums[j];
               if(sum==goal)
                 count++; 
            }
        }
        return count;
    }
// Approach 1
