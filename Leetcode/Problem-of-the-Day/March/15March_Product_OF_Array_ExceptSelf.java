// My Own Approach -

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] preSum=new int[n];
        int[] postSum=new int[n];

        int[] res=new int[n];

        for(int i=0;i<n;i++)
        {
            if(i==0)
                preSum[i]=nums[i];
            else
                preSum[i]=preSum[i-1]*nums[i];
        }
        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1)
                postSum[i]=nums[i];
            else
                postSum[i]=postSum[i+1]*nums[i];
        }

        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(postSum));

        for(int i=0;i<n;i++)
        {
            if(i==0)
                res[i]=postSum[i+1];
            else if(i==n-1)
                res[i]=preSum[i-1];
            else
                res[i]=preSum[i-1]*postSum[i+1];
        }

        return res;
    }
}



// Approach -O(n) PreSum(i) * PostSum(i)= res(i)

public int[] productExceptSelf(int[] nums) {
    int n=nums.length;
    int[] preSum=new int[n];
    int[] postSum=new int[n];

    int[] res=new int[n];
    preSum[0]=1;
    postSum[n-1]=1;
    for(int i=1;i<n;i++)
    {
        preSum[i]=preSum[i-1]*nums[i-1];
    }
    for(int i=n-2;i>=0;i--)
    {
        postSum[i]=postSum[i+1]*nums[i+1];
    }

    for(int i=0;i<n;i++)
    {
        res[i]=preSum[i]*postSum[i];
    }

    return res;
}
// Optimized Approach
public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int prefix = 1;
    for(int i=0; i<nums.length;i++){
        res[i] = prefix;
        prefix *= nums[i];
    }
    int postfix = 1;
    for(int j=nums.length-1; j>=0;j--){
        res[j]*=postfix;
        postfix*=nums[j];
    }
    return res;
}
