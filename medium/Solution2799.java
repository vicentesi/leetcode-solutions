import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2799 {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (Integer nbr : nums) {
            set.add(nbr);
        }
        
        int distinctNbrs = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        
        for(int right = 0; right < n; right++) {
            map.merge(nums[right], 1, Integer::sum);

            while(map.size() == distinctNbrs) {
                count += (n - right);

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }
        }

        return count;
    }

    /*
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        int distinctNbrs = Arrays.stream(nums).distinct().toArray().length;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();

            for(int j = i; j < n; j++) {
                seen.add(nums[j]);

                if (seen.size() == distinctNbrs ) {
                    count++;
                }                
            }
        }

        return count;
    }
    */

    /*
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        if (nums.length == 1)
            return 1;

        Map<Integer, Integer> distinct = new HashMap<>();

        for (int nbr : nums) {
            distinct.merge(nbr, 1, Integer::sum);
        }

        int distinctNbrs = distinct.keySet().size();
        int subArrCount = 0;
        
        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> distinctSub = new HashMap<>();

            for(int j = i; j < n; j++) {
                distinctSub.merge(nums[j], 1, Integer::sum);

                if (distinctSub.keySet().size() == distinctNbrs ) {
                    subArrCount++;
                }                
            }
        }

        return subArrCount;
    }
    */

    private void print(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}