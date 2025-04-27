class Solution2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        long count = 0;
        int lastMin = -1, lastMax = -1, lastBad = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                lastBad = i;
            if (nums[i] == minK)
                lastMin = i;
            if (nums[i] == maxK)
                lastMax = i;

            int valid = Math.min(lastMin, lastMax);

            if (valid > lastBad)
                count += valid - lastBad;
        }

        return count;
    }

    /*
     * public long countSubarrays(int[] nums, int minK, int maxK) {
     * int count = 0;
     * 
     * for (int i=0, j=0 ; i < nums.length; i++, j=i) {
     * boolean hasMin = false, hasMax = false;
     * 
     * while (j < nums.length && nums[j] >= minK && nums[j] <= maxK) {
     * if (nums[j] == minK) hasMin = true;
     * if (nums[j] == maxK) hasMax = true;
     * if (hasMin && hasMax ) count++;
     * j++;
     * }
     * }
     * 
     * return count;
     * }
     */

    public static void main(String[] args) {
        Solution2444 solution = new Solution2444();
        int[] nums = { 1, 3, 5, 2, 7, 5 };
        int minK = 2, maxK = 5;
        System.out.println(solution.countSubarrays(nums, minK, maxK));
    }
}

/*
 * 2444. Count Subarrays With Fixed Bounds
 * 
 * You are given an integer array nums and two integers minK and maxK.
 * 
 * A fixed-bound subarray of nums is a subarray that satisfies the following
 * conditions:
 * 
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * Example 2:
 * 
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10
 * possible subarrays.
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105
 * 1 <= nums[i], minK, maxK <= 106
 */