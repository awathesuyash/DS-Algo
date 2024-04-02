/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Example 1:

Input: s = "egg", t = "add"
Output: true*/

//Approach 1:

public boolean isIsomorphic(String s, String t) {
    int n1 = s.length();
    int n2 = t.length();

    if (n1 != n2)
        return false;

    HashMap<Character, Character> map1 = new HashMap<>();
    HashMap<Character, Boolean> map2 = new HashMap<>();

    for (int i = 0; i < n1; i++) {

        if (map1.containsKey(s.charAt(i))) {
            if (map1.get(s.charAt(i)) != t.charAt(i))
                return false;
        } else {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), true);
                map1.put(s.charAt(i), t.charAt(i));
            } else {
                return false;
            }
        }
    }
    return true;
}


