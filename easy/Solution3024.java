import java.util.Arrays;

class Solution3024 {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[2]) {
            return "equilateral";
        } else if (nums[0] != nums[1] && nums[1] != nums[2]) {
            return "scalene";
        } else {
            return "isosceles";
        }
    }

    /*
     * public String triangleType(int[] nums) {
     * Map<Integer, String> map = new HashMap<>() {{
     * put(0, "scalene");
     * put(1, "isosceles");
     * put(2, "isosceles");
     * put(3, "equilateral");
     * }};
     * int eqSides = 0;
     * boolean canForm = (nums[0] + nums[1] > nums[2] &&
     * nums[0] + nums[2] > nums[1] &&
     * nums[1] + nums[2] > nums[0]);
     * 
     * if (!canForm) return "none";
     * 
     * for (int i = 0; i < nums.length - 1; i++) {
     * for (int j = i + 1; j < nums.length; j++) {
     * if (nums[i] == nums[j]) {
     * eqSides++;
     * }
     * }
     * }
     * 
     * return map.get(eqSides);
     * }
     */

    public static void main(String[] args) {
        Solution3024 solution = new Solution3024();
        System.out.println(solution.triangleType(new int[] { 1, 1, 1 }));
    }
}

/*
 * 3024. Type of Triangle
 * 
 * You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.

 

Example 1:

Input: nums = [3,3,3]
Output: "equilateral"
Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.
Example 2:

Input: nums = [3,4,5]
Output: "scalene"
Explanation: 
nums[0] + nums[1] = 3 + 4 = 7, which is greater than nums[2] = 5.
nums[0] + nums[2] = 3 + 5 = 8, which is greater than nums[1] = 4.
nums[1] + nums[2] = 4 + 5 = 9, which is greater than nums[0] = 3. 
Since the sum of the two sides is greater than the third side for all three cases, therefore, it can form a triangle.
As all the sides are of different lengths, it will form a scalene triangle.
 

Constraints:

nums.length == 3
1 <= nums[i] <= 100
 */

