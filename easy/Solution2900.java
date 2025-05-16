import java.util.ArrayList;
import java.util.List;

class Solution2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> results = new ArrayList<>();
        results.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (groups[i - 1] != groups[i]) {
                results.add(words[i]);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Solution2900 solution = new Solution2900();
        String[] words = {"a", "b", "c", "d", "e"};
        int[] groups = {1, 2, 3, 4, 5};
        List<String> results = solution.getLongestSubsequence(words, groups);
        System.out.println(results);
    }
}

/*
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 * 
 * You are given a string array words and a binary array groups both of length n.

A subsequence of words is alternating if for any two consecutive strings in the sequence, their corresponding elements at the same indices in groups are different (that is, there cannot be consecutive 0 or 1).

Your task is to select the longest alternating subsequence from words.

Return the selected subsequence. If there are multiple answers, return any of them.

Note: The elements in words are distinct.

 

Example 1:

Input: words = ["e","a","b"], groups = [0,0,1]

Output: ["e","b"]

Explanation: A subsequence that can be selected is ["e","b"] because groups[0] != groups[2]. Another subsequence that can be selected is ["a","b"] because groups[1] != groups[2]. It can be demonstrated that the length of the longest subsequence of indices that satisfies the condition is 2.

Example 2:

Input: words = ["a","b","c","d"], groups = [1,0,1,1]

Output: ["a","b","c"]

Explanation: A subsequence that can be selected is ["a","b","c"] because groups[0] != groups[1] and groups[1] != groups[2]. Another subsequence that can be selected is ["a","b","d"] because groups[0] != groups[1] and groups[1] != groups[3]. It can be shown that the length of the longest subsequence of indices that satisfies the condition is 3.

 

Constraints:

1 <= n == words.length == groups.length <= 100
1 <= words[i].length <= 10
groups[i] is either 0 or 1.
words consists of distinct strings.
words[i] consists of lowercase English letters.
 */