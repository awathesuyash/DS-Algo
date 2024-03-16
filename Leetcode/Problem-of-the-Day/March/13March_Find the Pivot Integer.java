// Approach 1 
// Math : 1->x + x->n = 1->n
// x(x+1)/2 + x(x-1)/2 = n(n+1)/2
// x*x=n(n+1)/2;

    public int pivotInteger(int n) {
        
        int sum=n*(n+1)/2;
        double sq=Math.sqrt(sum);

        if(sq-Math.ceil(sq)==0) return (int)sq; 

        return -1;
    }
// Approach 2
// PrefixSum

    public int pivotInteger(int n) {
        
        int[] preSum=new int[n+1];
    // 0 1 3 6 
        for(int i=1;i<n+1;i++)
        {
            preSum[i]=preSum[i-1]+i;
        }

         for(int i=1;i<n+1;i++)
        {
            if(preSum[n]==preSum[i]+preSum[i-1])
            // if(preSum[i]==preSum[n]-preSum[i-1])  
             return i;
        }    

        return -1;
    }
