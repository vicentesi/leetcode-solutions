import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1636 {
  public int[] frequencySort(int[] nums) {
    int n = nums.length;

    Map<Integer, Integer> numsFreq = new HashMap<>();

    for (int num : nums) {
      numsFreq.put(num, numsFreq.getOrDefault(num, 0) + 1);
    }

    System.out.println("FreqMap: " + numsFreq.toString());

    Integer[] x = new Integer[n];
    for (int i = 0; i < n; i++) {
      x[i] = nums[i];
    }

    Arrays.sort(x, (a, b) -> {
      if (numsFreq.get(a).equals(numsFreq.get(b))) {
        return Integer.compare(b, a);
      }

      return Integer.compare(numsFreq.get(a), numsFreq.get(b));
    });

    for (int i = 0; i < n; i++) {
      nums[i] = x[i];
    }

    return nums;
  }

  public static void main(String[] args) {
    Solution1636 s = new Solution1636();

    // int[] f = { 1, 1, 2, 2, 2, 3 };
    // int[] f = { 2, 3, 1, 3, 2 };
    int[] f = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };

    System.out.println("Sorted: " + Arrays.toString(s.frequencySort(f)));
  }
}

/*
 * 1636. Sort Array by Increasing Frequency
 * 
 * Given an array of integers nums, sort the array in increasing order based on
 * the frequency of the values. If multiple values have the same frequency, sort
 * them in decreasing order.
 * 
 * Return the sorted array.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has
 * a frequency of 3.
 * Example 2:
 * 
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in
 * decreasing order.
 * Example 3:
 * 
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */