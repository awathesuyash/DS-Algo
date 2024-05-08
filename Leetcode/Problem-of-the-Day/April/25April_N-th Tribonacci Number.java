/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
*/

//Approach 1:

public int tribonacci(int n) {

    if(n<2) return n;
    int a = 0, b = 1, c = 1;
    int d;
    while (n-- > 2) {
        d = a + b + c;
        a = b;
        b = c;
        c = d;
    }
    return c;
}

// Approach 2:
public int tribonacci(int n) {

    if(n<2) return n;
    int a = 0, b = 1, c = 1;
    int d;
    for(int i=0;i<n-2;i++)
    {
        d = a + b + c;
        a = b;
        b = c;
        c = d;
    }
    return c;
}
// Approach 3
public int tribonacci(int n) {

    if (n ==0 || n==1)
        return n;
    if(n==2) return 1;

    int[] num = new int[n + 1];
    num[0] = 0;
    num[1] = 1;
    num[2] = 1;

    for (int i = 3; i <= n; i++) {
        num[i] = num[i - 1] + num[i - 2] + num[i - 3];
    }
    return num[n];
}