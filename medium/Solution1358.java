class Solution1358 {

    public int numberOfSubstrings(String s) {
        int result = 0;
        int[] count = new int[3];
        int sLen = s.length();
        int left = 0;
        int right = 0;

        while (right < sLen) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += sLen - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1358 solution = new Solution1358();
        System.out.println(solution.numberOfSubstrings("abcabc"));
    }
}

/*
 * 1358. Number of Substrings Containing All Three Characters
 * 
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
 * "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 * 
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 * 
 * Input: s = "abc"
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */