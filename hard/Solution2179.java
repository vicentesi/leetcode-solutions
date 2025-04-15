package hard;

class Solution {
    class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size + 1;
            tree = new int[this.size];
        }

        void update(int index, int value) {
            index++;
            while (index < size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        FenwickTree bit = new FenwickTree(n);
        int[] leftSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            leftSmaller[i] = bit.query(mapped[i] - 1);
            bit.update(mapped[i], 1);
        }

        bit = new FenwickTree(n);
        int[] rightGreater = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = bit.query(n - 1) - bit.query(mapped[i]);
            bit.update(mapped[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long) leftSmaller[i] * rightGreater[i];
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 2, 0, 1, 3 };
        int[] nums2 = { 0, 1, 2, 3 };
        System.out.println(solution.goodTriplets(nums1, nums2)); // Output: 0

        int[] nums1_2 = { 4, 0, 1, 3, 2 };
        int[] nums2_2 = { 4, 1, 0, 2, 3 };
        System.out.println(solution.goodTriplets(nums1_2, nums2_2)); // Output: 0
    }
}

/*
 * 2179. Count Good Triplets in an Array
 * 
 * You are given two 0-indexed arrays nums1 and nums2 of length n, both of which
 * are permutations of [0, 1, ..., n - 1].
 * 
 * A good triplet is a set of 3 distinct values which are present in increasing
 * order by position both in nums1 and nums2. In other words, if we consider
 * pos1v as the index of the value v in nums1 and pos2v as the index of the
 * value v in nums2, then a good triplet will be a set (x, y, z) where 0 <= x,
 * y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
 * 
 * Return the total number of good triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3]
 * Output: 1
 * Explanation:
 * There are 4 triplets (x,y,z) such that pos1x < pos1y < pos1z. They are
 * (2,0,1), (2,0,3), (2,1,3), and (0,1,3).
 * Out of those triplets, only the triplet (0,1,3) satisfies pos2x < pos2y <
 * pos2z. Hence, there is only 1 good triplet.
 * Example 2:
 * 
 * Input: nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
 * Output: 4
 * Explanation: The 4 good triplets are (4,0,3), (4,0,2), (4,1,3), and (4,1,2).
 * 
 * 
 * Constraints:
 * 
 * n == nums1.length == nums2.length
 * 3 <= n <= 105
 * 0 <= nums1[i], nums2[i] <= n - 1
 * nums1 and nums2 are permutations of [0, 1, ..., n - 1].
 */

 /*
  * NAIVE SOLUTION:
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    class Solution {
        public long goodTriplets(int[] nums1, int[] nums2) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            results = backtrack(results, nums1, 0, current);
            return countGoodTriplets(results, nums2);
        }

        private List<List<Integer>> backtrack(List<List<Integer>> results, int[] nums1, int index, List<Integer> current) {
            if (current.size() == 3) {
                results.add(new ArrayList<>(current));
                return results;
            }

        for (int i = index; i < nums1.length; i++) {
                current.add(nums1[i]);
                results = backtrack(results, nums1, i + 1, current);
                current.remove(current.size() - 1);
            }

            return results;
        }

        private long countGoodTriplets(List<List<Integer>> results, int[] nums2) {
            Map<Integer, Integer> posMap = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                posMap.put(nums2[i], i);
            }

            long count = 0;
            int x=0,y=0,z=0;

            for (List<Integer> list : results) {      
                x = posMap.get(list.get(0));
                y = posMap.get(list.get(1));
                z = posMap.get(list.get(2));

                if (x < y && y < z)
                    count++;
            }

            return count;
        }
    }   
  */