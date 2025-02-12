import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2342 {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        Map<Integer, ArrayList<Integer>> sums = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            String x = nums[i] + "";
            Integer aux = 0;

            for (int j = 0; j < x.length(); j++) {
                aux += Integer.parseInt(x.charAt(j) + "");
            }

            sums.putIfAbsent(aux, new ArrayList<>());
            sums.get(aux).add(i);
        }

        List<Integer> sortedKeys = new ArrayList<>(sums.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());
        Integer first = sortedKeys.get(0);
        ArrayList<Integer> values = sums.get(first);

        if (values.size() > 1) {
            Collections.sort(values, Collections.reverseOrder());
            maxSum = Math.max(maxSum, values.get(0) + values.get(1));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution2342 mySolution = new Solution2342();
        int[] nums = { 18, 43, 36, 13, 7 };
        System.out.println(mySolution.maximumSum(nums));
    }
}