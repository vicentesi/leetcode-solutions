class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int m = i + (j - i) / 2;

            if (target == nums[m])
                return m;

            if (target < nums[m]) {
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            }
        }

        return i;
    }
}

public class Solution35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(solution.searchInsert(nums, target)); // Output: 2

        target = 2;
        System.out.println(solution.searchInsert(nums, target)); // Output: 1

        target = 7;
        System.out.println(solution.searchInsert(nums, target)); // Output: 4

        target = 0;
        System.out.println(solution.searchInsert(nums, target)); // Output: 0
    }
}

/*
 * BINARY SEARCH
 * 
 * 35. Search Insert Position
 * 
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */