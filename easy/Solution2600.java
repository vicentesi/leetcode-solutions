class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;

        if (numOnes >= k) {            
            return k;
        } else {
            sum += numOnes;
            k -= numOnes;
        }

        if (numZeros >= k) {
            return sum;
        } else {
            k -= numZeros;
        }

        if (numNegOnes >= k) {
            return sum + (k * -1);
        } else {
            sum += (numNegOnes * -1);
            k -= numNegOnes;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution2600 s = new Solution2600();

        // int r = s.kItemsWithMaximumSum(3, 2, 0, 2);
        int r = s.kItemsWithMaximumSum(3, 2, 0, 4);

        System.out.println("Output: " + r);
    }
}