/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.*/


//Approach1:
public String removeKdigits(String num, int k) {
    int n = num.length();
    if (n == k)
        return "0";
    // 1432219
    Stack<Character> stack = new Stack<>();
    for (char curr : num.toCharArray()) {
        while (!stack.isEmpty() && k > 0 && stack.peek() > curr) {
            stack.pop();
            k--;
        }
        stack.push(curr);
    }
    // stack :[9,1,2,1]
    // If K is not 0 , then remove all element till k==0 ,which give smallest num
    while (!stack.isEmpty() && k > 0) {
        stack.pop();
        k--;
    }
    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
        res.append(stack.peek());
        stack.pop();
    }
    // Now :res["9121"]
    res.reverse(); // ["1219"]

    // Incase Trailing 0, so remove them
    while (res.length() > 0 && res.charAt(0) == '0') {
        res.deleteCharAt(0);
    }
    return res.length() > 0 ? res.toString() : "0";
}