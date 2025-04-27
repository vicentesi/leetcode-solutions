import java.util.Stack;

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                break;
                default:
                    stack.push(c);
            }
        }

        if (stack.empty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }
}

/*
 * 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
