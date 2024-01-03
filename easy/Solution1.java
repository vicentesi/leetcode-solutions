import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - 1; j > i; j--) {

                if ((nums[i] + nums[j]) == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int x = target - current;

            if (map.containsKey(x)) {
                arr[0] = i;
                arr[1] = map.get(x);
                break;
            } else {
                map.put(current, i);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = sol.twoSum(nums, target);
        int[] resultV2 = sol.twoSumV2(nums, target);
        
        System.out.println(result[0] + " " + result[1]);
        System.out.println(resultV2[0] + " " + resultV2[1]);
    }
}

/*
 * 1. Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */