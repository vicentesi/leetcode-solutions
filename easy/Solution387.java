import java.util.HashMap;

public class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (freq.get(c) != null) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        for (int j = 0; j < s.length(); j++) {
            if (freq.get(s.charAt(j)) == 1) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution387 s = new Solution387();

        String str = "leetcode";
        String str1 = "loveleetcode";
        String str2 = "aabb";

        System.out.println(str + " -> " + s.firstUniqChar(str));
        System.out.println(str1 + " -> " + s.firstUniqChar(str1));
        System.out.println(str2 + " -> " + s.firstUniqChar(str2));
    }
}

/*
 * 387. First Unique Character in a String Easy
 * 
 * 
 * Given a string, find the first non-repeating character in it and return its
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * s = "loveleetcode" return 2.
 * s = "aabb" return -1.
 * 
 * Note: You may assume the string contains only lowercase English letters.
 */
