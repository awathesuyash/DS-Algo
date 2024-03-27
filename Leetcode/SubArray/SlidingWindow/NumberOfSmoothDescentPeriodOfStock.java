/*
You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.

A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.

Return the number of smooth descent periods.



        Example 1:

Input: prices = [3,2,1,4]
Output: 7
Explanation: There are 7 smooth descent periods:
        [3], [2], [1], [4], [3,2], [2,1], and [3,2,1]
Note that a period with one day is a smooth descent period by the definition.*/

/ Easy Apporach:
public long getDescentPeriods(int[] prices) {

    int n = prices.length;
    int count = 1;
    long ans = 1;
    for (int i = 1; i < n; i++) {
        if (prices[i - 1] - prices[i] == 1)
            ++count;
        else
            count = 1;

        ans += count;
    }
    return ans;

}

//Sliding Window: 1
public long getDescentPeriods(int[] prices) {

    int n = prices.length;
    long count = 0;
    for (int start = 0, end = 0; end < n; end++) {
        while (end != 0 && start < end && (prices[end - 1] - prices[end] != 1)) {
            start++;
        }
        count += end - start + 1;
    }
    return count;
}

// Sliding WIndow 2 : Combined Approach (1 +2)
public long getDescentPeriods(int[] prices) {

    int start = 0, end = 1;
    long count = 0, ans = 1;
    while (end < prices.length) {
        if (prices[end - 1] == 1 + prices[end]) {
            //It means that j(current element) can be part of previous subarrays (j-i)
            //and can also start a subarray from me (+1). So add (j-i+1) in total Subarrays
            count = end - start + 1;
            ans += count;
        } else {
            //It means that j cannot be part of previous subarrays but can start subarray from me. So, ans+=1
            ans += 1;
            start = end;
        }
        end++;
    }
    return ans;
}