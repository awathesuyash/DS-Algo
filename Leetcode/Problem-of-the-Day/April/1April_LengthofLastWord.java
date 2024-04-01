/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
        substring
consisting of non-space characters only.



        Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.*/

//Approach1: Lastword count ,so start counting from last

class Solution {
    public int lengthOfLastWord(String s) {
        // " fly me to the moon "
        s=s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0)
                    return count;
            }
        }
        return count;
    }

// Approach 2:
public int lengthOfLastWord(String s) {
    // " fly me to the moon "

    return s.trim().length()-s.trim().lastIndexOf(' ')-1;
}

