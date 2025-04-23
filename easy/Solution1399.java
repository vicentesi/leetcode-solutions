import java.util.Arrays;

class Solution1399 {
    public int countLargestGroup(int n) {
        int[] groups = new int[37];
        Arrays.fill(groups, 0);
        
        for (int i = 1; i <= n; i++) {
            int group = calculateGroup(i);
            groups[group]++;
        }

        int max = Arrays.stream(groups)
                        .max()
                        .orElseThrow();
                        
        int count = (int) Arrays.stream(groups)
                                .filter(x -> x == max)
                                .count();

        return count;
    }

    private int calculateGroup(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution1399 solution = new Solution1399();
        System.out.println(solution.countLargestGroup(13));
    }
}

/*
 * 1399. Count Largest Group
 * 
 * You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.

 

Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
 

Constraints:

1 <= n <= 10^4
 */