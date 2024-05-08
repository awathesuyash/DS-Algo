/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.*/

//Approach 1: Recurrsion
public int fib(int n) {

    if (n == 0 || n == 1)
        return n;
    if (n == 2)
        return 1;

    return fib(n - 1) + fib(n - 2);
}

//Approach 2:
public int fib(int n) {

    if (n == 0 || n == 1)
        return n;
    if (n == 2)
        return 1;

    int a = 0, b = 1;
    while (n-- > 1) {
        int c = a + b; //1 -2
        a = b; //a=1
        b = c; // b=1 - 2
    }
    return b;
}
// Approach : DP
public int fib(int n) {

    if (n == 0 || n == 1)
        return n;
    if (n == 2)
        return 1;

    int[] num = new int[n + 1];
    num[0] = 0;
    num[1] = 1;

    for (int i = 2; i <= n; i++) {
        num[i] = num[i - 1] + num[i - 2];
    }
    return num[n];
}