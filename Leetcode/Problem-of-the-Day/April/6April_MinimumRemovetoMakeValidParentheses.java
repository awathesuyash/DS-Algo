/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

        Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.*/


//Appraoch 1: Using Stack
public String minRemoveToMakeValid(String s) {

    Stack<Integer> stack = new Stack<>();
    StringBuilder sb=new StringBuilder(s);

    for (int i = 0; i < s.length(); i++) {
        if (sb.charAt(i) == '(') {
            stack.push(i);
        } else if (sb.charAt(i) == ')') {
            if (stack.isEmpty()) {
                sb.setCharAt(i,'#');
            } else {
                stack.pop();
            }
        }
    }

    while(!stack.isEmpty())
    {
        int extra=stack.peek();
        sb.setCharAt(extra,'#');
        stack.pop();
    }
    StringBuilder ans=new StringBuilder();
    for(int i=0;i<sb.length();i++)
    {
        if(sb.charAt(i) !='#')
            ans.append(sb.charAt(i));
    }

    return ans.toString();
}

//Approach2: Two-Pass Approach
public String minRemoveToMakeValid(String s) {
    int count = 0;
    StringBuilder sb = new StringBuilder(s);
    // For Extra closing braces -- "ab(c)d)"
    for (int i = 0; i < s.length(); i++) {
        if (sb.charAt(i) == '(') {
            count++;
        } else if (sb.charAt(i) == ')') {
            if (count == 0) {
                sb.setCharAt(i, '#');
            } else {
                count--;
            }
        }
    }
    // For Extra opening braces --"a(b(c)"
    count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (sb.charAt(i) == ')') {
            count++;
        } else if (sb.charAt(i) == '(') {
            if (count == 0) {
                sb.setCharAt(i, '#');
            } else {
                count--;
            }
        }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) != '#')
            ans.append(sb.charAt(i));
    }
    return ans.toString();
}
