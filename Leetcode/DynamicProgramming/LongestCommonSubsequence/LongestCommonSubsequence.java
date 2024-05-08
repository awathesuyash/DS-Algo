//https://leetcode.com/problems/longest-common-subsequence/description/

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.*/


// Approach : Recursion
public int LCS(String text1, String text2, int m, int n) {

    if (m == 0 || n == 0)
        return 0;

    if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
        return 1 + LCS(text1, text2, m - 1, n - 1);
    }
    return Math.max(LCS(text1, text2, m, n - 1), LCS(text1, text2, m - 1, n));
}

public int longestCommonSubsequence(String text1, String text2) {

    int m = text1.length();
    int n = text2.length();

    return LCS(text1, text2, m, n);

}

// Approach : Memoization


static int dp[][] = new int[1001][1001];

public int LCS(String text1, String text2, int m, int n) {

    if (m == 0 || n == 0)
        return 0;

    if (dp[m][n] != -1)
        return dp[m][n];

    if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
        return dp[m][n] = 1 + LCS(text1, text2, m - 1, n - 1);
    }
    return dp[m][n] = Math.max(LCS(text1, text2, m, n - 1), LCS(text1, text2, m - 1, n));
}

public int longestCommonSubsequence(String text1, String text2) {

    int m = text1.length();
    int n = text2.length();

    for (int[] row : dp)
        Arrays.fill(row, -1);

    return LCS(text1, text2, m, n);

}