import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//public class KthLargest {
public class Solution703 {
    int k;
    List<Integer> list = new ArrayList<>();

    public Solution703(int k, int[] nums) {
        this.k = k;
        this.list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
    }

    public int add(int val) {
        list.add(val);
        list.sort((a, b) -> b.compareTo(a));
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        Solution703 kl = new Solution703(3, new int[] { 4, 5, 8, 2 });

        System.out.println("add(3) returns " + kl.add(3)); // return 4
        System.out.println("add(5) returns " + kl.add(5)); // return 5
        System.out.println("add(10) returns " + kl.add(10)); // return 5
        System.out.println("add(9) returns " + kl.add(9)); // return 8
        System.out.println("add(4) returns " + kl.add(4)); // return 8
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/*
 * 703. Kth Largest Element in a Stream
 * 
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the
 * element representing the kth largest element in the stream.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 * 
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * At most 104 calls will be made to add.
 * It is guaranteed that there will be at least k elements in the array when you
 * search for the kth element.
 */