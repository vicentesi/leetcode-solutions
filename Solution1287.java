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
