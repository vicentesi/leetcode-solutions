public class Main {
    public static void main(String[] args) {

        int[] testArr = { 1, 2, 3, 3 };

        Solution1287 s = new Solution1287();
        Solution1464 s2 = new Solution1464();

        System.out.println(s.findSpecialInteger(testArr));
        System.out.println(s2.maxProduct(testArr));
    }
}

