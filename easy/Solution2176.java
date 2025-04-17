class Solution2176 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int pairs = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && ((i * j) % k == 0)) {
                    pairs++;
                }
            }
        }

        return pairs;
    }

    // alt 2
    /*
     * public int countPairs(int[] nums, int k) {
     * int n = nums.length;
     * int count = 0;
     * 
     * Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
     * 
     * for (int j = 0; j < n; j++) {
     * int value = nums[j];
     * 
     * if (valueToIndices.containsKey(value)) {
     * for (int i : valueToIndices.get(value)) {
     * if ((i * j) % k == 0) {
     * count++;
     * }
     * }
     * }
     * 
     * valueToIndices
     * .computeIfAbsent(value, v -> new ArrayList<>())
     * .add(j);
     * }
     * 
     * return count;
     * }
     */

    // alt
    /*
     * public int countPairs(int[] nums, int k) {
     * Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
     * int pairs = 0;
     * 
     * for (int i = 0; i < nums.length; i++) {
     * valueToIndices
     * .computeIfAbsent(nums[i], v -> new ArrayList<>())
     * .add(i);
     * }
     * 
     * for (List<Integer> indices : valueToIndices.values()) {
     * int size = indices.size();
     * if (size > 1) {
     * for (int i = 0; i < size; i++) {
     * for (int j = i + 1; j < size; j++) {
     * int idx1 = indices.get(i);
     * int idx2 = indices.get(j);
     * if ((idx1 * idx2) % k == 0) {
     * pairs++;
     * }
     * }
     * }
     * }
     * }
     * 
     * return pairs;
     * }
     */

    /*
     * public int countPairs(int[] nums, int k) {
     * Map<Integer, Integer> mapEntrys = new HashMap<>();
     * Map<Integer, Integer> mapIdx = new HashMap<>();
     * int n = nums.length;
     * int pairs = 0;
     * 
     * for (int i = 0; i < n; i++) {
     * mapIdx.put(i, nums[i]);
     * mapEntrys.put(nums[i], mapEntrys.getOrDefault(nums[i], 0) + 1);
     * }
     * 
     * for (Map.Entry<Integer, Integer> entry : mapEntrys.entrySet()) {
     * if (entry.getValue() > 1) {
     * Integer key = entry.getKey();
     * 
     * List<Integer> keysWithValue = mapIdx.entrySet()
     * .stream()
     * .filter(e -> e.getValue().equals(key))
     * .map(Map.Entry::getKey)
     * .collect(Collectors.toList());
     * 
     * Integer[] idxArr = keysWithValue.toArray(new Integer[keysWithValue.size()]);
     * 
     * for (int i = 0; i < idxArr.length - 1; i++) {
     * for (int j = i + 1; j < idxArr.length; j++) {
     * if ((idxArr[i] * idxArr[j]) % k == 0) {
     * pairs++;
     * }
     * }
     * }
     * }
     * }
     * 
     * return pairs;
     * }
     */

     public static void main(String[] args) {
        Solution2176 solution = new Solution2176();
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        System.out.println(solution.countPairs(nums, k)); // Output: 4

        nums = new int[]{1, 2, 3, 4};
        k = 1;
        System.out.println(solution.countPairs(nums, k)); // Output: 0
     }
}

/*
 * 2176. Count Equal and Divisible Pairs in an Array
 * 
 * Given a 0-indexed integer array nums of length n and an integer k, return the
 * number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and
 * (i * j) is divisible by k.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,2,2,2,1,3], k = 2
 * Output: 4
 * Explanation:
 * There are 4 pairs that meet all the requirements:
 * - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
 * - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
 * - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
 * - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
 * Example 2:
 * 
 * Input: nums = [1,2,3,4], k = 1
 * Output: 0
 * Explanation: Since no value in nums is repeated, there are no pairs (i,j)
 * that meet all the requirements.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 */