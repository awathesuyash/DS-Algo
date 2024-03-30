/*
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).



Example 1:

Input: s = "ca"
Output: 2
Explanation: You can't remove any characters, so the string stays as is.
Example 2:

Input: s = "cabaabac"
Output: 0
Explanation: An optimal sequence of operations is:
        - Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
        - Take prefix = "a" and suffix = "a" and remove them, s = "baab".
        - Take prefix = "b" and suffix = "b" and remove them, s = "aa".
        - Take prefix = "a" and suffix = "a" and remove them, s = ""
*/



// Approach 1:
public int minimumLength(String s) {

    int i = 0, j = s.length() - 1;

    while (i < j && s.charAt(i) == s.charAt(j)) {
        char ch = s.charAt(i);
        while (i < j && s.charAt(i) == ch) {
            i++;
        }
        while (j >= i && s.charAt(j) == ch) {
            j--;
        }
    }

    return j - i + 1;
}

//Aprroach 2:
public int minimumLength(String s) {

    int i = 0, j = s.length() - 1;

    while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            break;
        }
        while (i < j && s.charAt(i) == s.charAt(i + 1)) {
            i++;
        }
        while (i<j && s.charAt(j) == s.charAt(j - 1)) {
            j--;
        }
        i++;
        j--;
    }
    return (j < i) ? 0 : (j - i + 1);
}

