class Solution1869 {
  public boolean checkZeroOnes(String s) {
    int ones = 0;
    int zeros = 0;

    int localOnes = 0;
    int localZeros = 0;

    int idx = 0;

    while (idx < s.length()) {
      if (s.charAt(idx) == '0') {
        localZeros++;

        if ((idx > 0 && s.charAt(idx - 1) == '1')) {
          if (localOnes > ones)
            ones = localOnes;
          localOnes = 0;
        }

        if (localZeros > zeros)
          zeros = localZeros;
      }

      if (s.charAt(idx) == '1') {
        localOnes++;

        if ((idx > 0 && s.charAt(idx - 1) == '0')) {
          if (localZeros > zeros)
            zeros = localZeros;
          localZeros = 0;
        }

        if (localOnes > ones)
          ones = localOnes;
      }

      idx++;
    }

    return ones > zeros;

  }

  public static void main(String[] args) {
    Solution1869 s = new Solution1869();

    // System.out.println(s.checkZeroOnes("1101"));
    System.out.println(s.checkZeroOnes("111000"));
    // System.out.println(s.checkZeroOnes("110100010"));
    // System.out.println(s.checkZeroOnes("1"));
  }
}

/*
 * 1869. Longer Contiguous Segments of Ones than Zeros
 * 
 * Given a binary string s, return true if the longest contiguous segment of 1's
 * is strictly longer than the longest contiguous segment of 0's in s, or return
 * false otherwise.
 * 
 * For example, in s = "110100010" the longest continuous segment of 1s has
 * length 2, and the longest continuous segment of 0s has length 3.
 * Note that if there are no 0's, then the longest continuous segment of 0's is
 * considered to have a length 0. The same applies if there is no 1's.
 * 
 * Example 1:
 * 
 * Input: s = "1101"
 * Output: true
 * Explanation:
 * The longest contiguous segment of 1s has length 2: "1101"
 * The longest contiguous segment of 0s has length 1: "1101"
 * The segment of 1s is longer, so return true.
 * Example 2:
 * 
 * Input: s = "111000"
 * Output: false
 * Explanation:
 * The longest contiguous segment of 1s has length 3: "111000"
 * The longest contiguous segment of 0s has length 3: "111000"
 * The segment of 1s is not longer, so return false.
 * Example 3:
 * 
 * Input: s = "110100010"
 * Output: false
 * Explanation:
 * The longest contiguous segment of 1s has length 2: "110100010"
 * The longest contiguous segment of 0s has length 3: "110100010"
 * The segment of 1s is not longer, so return false.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100
 * s[i] is either '0' or '1'.
 */