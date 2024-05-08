/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.


Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".*/

//Approach 2:
public int compareVersion(String version1, String version2) {

    int n1 = version1.length();
    int n2 = version2.length();

    int i = 0, j = 0;
    int temp1 = 0, temp2 = 0;
    while (i < n1 || j < n2) {
        temp1 = 0;
        temp2 = 0;
        while (i < n1 && version1.charAt(i) != '.') {
            temp1 = temp1 * 10 + version1.charAt(i) - '0';
            i++;
        }
        while (j < n2 && version2.charAt(j) != '.') {
            temp2 = temp2 * 10 + version2.charAt(j) - '0';
            j++;
        }
        if (temp1 < temp2) {
            return -1;
        } else if (temp1 > temp2)
            return 1;
        else {
            i++;
            j++;
        }
    }
    return 0;
}

//Approach2: Split Function

public int compareVersion(String version1, String version2) {

    int n1 = version1.length();
    int n2 = version2.length();

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    for (int i = 0; i < Math.max(n1, n2); i++) {
        int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
        int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

        if (num1 < num2)
            return -1;
        else if (num1 > num2)
            return 1;

    }
    return 0;

}
