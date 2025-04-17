// import java.util.HashMap;
// import java.util.Map;

class Solution383 {

    // Using an array to count the frequency of characters in magazine
    // and check if ransomNote can be constructed from it.
    // Time complexity: O(n + m), where n is the length of ransomNote and m is the length of magazines
    // Space complexity: O(1), since the size of the frequency array is constant (26 for lowercase letters)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0)
                return false;
        }

        return true;
    }

    // Alternative solution using HashMap
    // Time complexity: O(n + m), where n is the length of ransomNote and m is the length of magazines
    // Space complexity: O(n), where n is the number of unique characters in ransomNote
    /*
     * public boolean canConstruct(String ransomNote, String magazine) {
     * if (ransomNote.length() > magazine.length())
     * return false;
     * 
     * Map<Character, Integer> freqNot = new HashMap<>();
     * 
     * for (int i = 0; i < ransomNote.length(); i++) {
     * Character c = ransomNote.charAt(i);
     * freqNot.put(c, freqNot.getOrDefault(c, 0) + 1);
     * }
     * 
     * for (int j = 0; j < magazine.length(); j++) {
     * Character c = magazine.charAt(j);
     * if (freqNot.containsKey(c)) {
     * freqNot.put(c, freqNot.get(c) - 1);
     * }
     * }
     * 
     * return freqNot.values().stream().allMatch(count -> count <= 0);
     * }
     */

    public static void main(String[] args) {
        Solution383 solution = new Solution383();
        System.out.println(solution.canConstruct("a", "b")); // false
        System.out.println(solution.canConstruct("aa", "ab")); // false
        System.out.println(solution.canConstruct("aa", "aab")); // true
    }
}

/*
 * 383. Ransom Note
 * 
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
