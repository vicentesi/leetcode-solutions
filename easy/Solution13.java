import java.util.HashMap;
import java.util.Map;

class Solution13 {
  public int romanToInt(String s) {
    int sLength = s.length();
    int sum = 0;
    int i = 0;

    while (i < s.length()) {

      switch (s.charAt(i)) {
        case 'I':
          if (i + 1 < sLength && s.charAt(i + 1) == 'V') {
            sum += 4;
            i += 2;
          } else if (i + 1 < sLength && s.charAt(i + 1) == 'X') {
            sum += 9;
            i += 2;
          } else {
            sum += 1;
            i += 1;
          }
          break;
        case 'X':
          if (i + 1 < sLength && s.charAt(i + 1) == 'L') {
            sum += 40;
            i += 2;
          } else if (i + 1 < sLength && s.charAt(i + 1) == 'C') {
            sum += 90;
            i += 2;
          } else {
            sum += 10;
            i += 1;
          }
          break;
        case 'C':
          if (i + 1 < sLength && s.charAt(i + 1) == 'D') {
            sum += 400;
            i += 2;
          } else if (i + 1 < sLength && s.charAt(i + 1) == 'M') {
            sum += 900;
            i += 2;
          } else {
            sum += 100;
            i += 1;
          }
          break;
        default:
          switch (s.charAt(i)) {
            case 'V':
              sum += 5;
              i += 1;
              break;
            case 'L':
              sum += 50;
              i += 1;
              break;
            case 'D':
              sum += 500;
              i += 1;
              break;
            case 'M':
              sum += 1000;
              i += 1;
              break;
          }
      }
    }

    return sum;
  }

  // solução CHATGPT (romanToInt2)
  public int romanToInt2(String s) {
    Map<Character, Integer> romanValues = new HashMap<>();
    romanValues.put('I', 1);
    romanValues.put('V', 5);
    romanValues.put('X', 10);
    romanValues.put('L', 50);
    romanValues.put('C', 100);
    romanValues.put('D', 500);
    romanValues.put('M', 1000);

    int sLength = s.length();
    int sum = 0;

    for (int i = 0; i < sLength; i++) {
      int value = romanValues.get(s.charAt(i));
      if (i + 1 < sLength && value < romanValues.get(s.charAt(i + 1))) {
        sum -= value;
      } else {
        sum += value;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    Solution13 obj = new Solution13();

    System.out.println(obj.romanToInt2("III"));
    System.out.println(obj.romanToInt2("IV"));
    System.out.println(obj.romanToInt2("IX"));
    System.out.println(obj.romanToInt2("LVIII"));
    System.out.println(obj.romanToInt2("MCMXCIV"));
  }
}

/*
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * For example, 2 is written as II in Roman numeral, just two one's added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * 
 * Example 2:
 * Input: s = "IV"
 * Output: 4
 * 
 * Example 3:
 * Input: s = "IX"
 * Output: 9
 * 
 * Example 4:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * Example 5:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * 
 * Runtime: 5 ms, faster than 99.93% of Java online submissions for Roman to
 * Integer.
 * Memory Usage: 39.3 MB, less than 61.92% of Java online submissions for Roman
 * to Integer.
 * 
 * Time complexity: O(n) // O(n) because we iterate through the input string. n
 * is the length of the input string.
 * Space complexity: O(1) // O(1) because the number of roman numerals is fixed.
 * We are not using any extra space that grows with the input size.
 * Where n is the length of the input string.
 * 
 */
