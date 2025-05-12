
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2094 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        backtrack(set, digits, new StringBuilder(), used);

        return set.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void backtrack(Set<Integer> set, int[] digits, StringBuilder current, boolean[] used) {
        if (current.length() == 3) {
            int num = Integer.parseInt(current.toString());
            if (num % 2 == 0 && current.charAt(0) != '0') {
                set.add(num);
            }
            return;
        }

        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            if (seen.contains(digits[i])) continue;

            seen.add(digits[i]);
            used[i] = true;
            current.append(digits[i]);
            backtrack(set, digits, current, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution2094 solution = new Solution2094();
        int[] digits = {2, 1, 3, 0};
        int[] result = solution.findEvenNumbers(digits);
        System.out.println(Arrays.toString(result));
    }

}

/*
 * 2094. Finding 3-Digit Even Numbers
 * 
 * You are given an integer array digits, where each element is a digit. The array may contain duplicates.

You need to find all the unique integers that follow the given requirements:

The integer consists of the concatenation of three elements from digits in any arbitrary order.
The integer does not have leading zeros.
The integer is even.
For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

Return a sorted array of the unique integers.

 

Example 1:

Input: digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
Explanation: All the possible integers that follow the requirements are in the output array. 
Notice that there are no odd integers or integers with leading zeros.
Example 2:

Input: digits = [2,2,8,8,2]
Output: [222,228,282,288,822,828,882]
Explanation: The same digit can be used as many times as it appears in digits. 
In this example, the digit 8 is used twice each time in 288, 828, and 882. 
Example 3:

Input: digits = [3,7,5]
Output: []
Explanation: No even integers can be formed using the given digits.
 

Constraints:

3 <= digits.length <= 100
0 <= digits[i] <= 9
 */