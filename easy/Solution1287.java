import java.util.HashMap;
import java.util.Map;

class Solution1287 {
    
    // O(n)
    public int findSpecialInteger(int[] arr) {
        int arrSize = arr.length;
        int twentyFivePct = (int)(arrSize * 0.25);

        Map<Integer, Integer> numberCountMap = new HashMap<>();

        for (int num : arr) {
            numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
            if (numberCountMap.get(num) > twentyFivePct) {
                return num;
            }
        }

        return -1; // Error
    }
}

/*
 * 1287. Element Appearing More Than 25% In Sorted Array
 * 
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * 
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time. Return that integer.
 * 
 * Example 1: 
 * Input: arr = [1,2,2,6,6,6,6,7,10] 
 * Output: 6
 * 
 * Constraints: 
 * 1 <= arr.length <= 10^4 
 * 0 <= arr[i] <= 10^5
 */
