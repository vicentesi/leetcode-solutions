class Solution3335 {

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        long MOD = 1_000_000_007;

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

         for (int i = 0; i < t; i++) {
            long[] next = new long[26];

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) continue;

                if (j == 25) {
                    next[0] = (next[0] + freq[25]) % MOD;
                    next[1] = (next[1] + freq[25]) % MOD;
                } else {
                    next[j + 1] = (next[j + 1] + freq[j]) % MOD;
                }
            }
            
            freq = next;
         }

        long result = 0;
        for (long count : freq) {
            result = (result + count) % MOD;
        }
        return (int) result;
    }

    // public int lengthAfterTransformations(String s, int t) {
    //     String alph = "abcdefghijklmnopqrstuvwxyz";
    //     long MOD = 1_000_000_007;

    //     for (int i = 1; i <= t; i++) {
    //         StringBuilder sb = new StringBuilder();

    //         for (int j = 0; j < s.length(); j++) {
    //             char c = s.charAt(j);

    //             if (c == 'z') {
    //                 sb.append("ab");
    //                 continue;
    //             }
                
    //             int idx = c - 'a';
    //             sb.append(alph.charAt(idx + 1));
    //         }

    //         s = sb.toString();
    //     }

    //     return s.length();
    // }

    public static void main(String[] args) {
        Solution3335 solution = new Solution3335();
        System.out.println(solution.lengthAfterTransformations("abc", 1));
    }
}