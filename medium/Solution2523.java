import java.util.Arrays;

class Solution2523 {

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveOfEratosthenes(right);
        int[] ans = { -1, -1 };
        int prevPrime = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        ans[0] = prevPrime;
                        ans[1] = i;
                        minDiff = diff;
                        if (minDiff == 2) {
                            break;
                        }
                    }
                }
                prevPrime = i;
            }
        }

        return ans;
    }

    private boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        Solution2523 solution = new Solution2523();
        int[] result = solution.closestPrimes(10, 30);
        int[] result2 = solution.closestPrimes(4, 6);
        int[] result3 = solution.closestPrimes(19, 31);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}

/*
 * 2523. Closest Prime Numbers in Range
 * 
 * Given two positive integers left and right, find the two integers num1 and
 * num2 such that:
 * 
 * left <= num1 < num2 <= right .
 * Both num1 and num2 are prime numbers.
 * num2 - num1 is the minimum amongst all other pairs satisfying the above
 * conditions.
 * Return the positive integer array ans = [num1, num2]. If there are multiple
 * pairs satisfying these conditions, return the one with the smallest num1
 * value. If no such numbers exist, return [-1, -1].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: left = 10, right = 19
 * Output: [11,13]
 * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 * The closest gap between any pair is 2, which can be achieved by [11,13] or
 * [17,19].
 * Since 11 is smaller than 17, we return the first pair.
 * Example 2:
 * 
 * Input: left = 4, right = 6
 * Output: [-1,-1]
 * Explanation: There exists only one prime number in the given range, so the
 * conditions cannot be satisfied.
 * 
 * 
 * Constraints:
 * 
 * 1 <= left <= right <= 106
 */