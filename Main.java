public class Main {
    public static void main(String[] args) {

        int[] intArray = { 1, 2, 3, 3 };

        Solution1287 s1287 = new Solution1287();
        Solution1464 s1464 = new Solution1464();
        Solution2706 s2706 = new Solution2706();

        System.out.println(s1287.findSpecialInteger(intArray));
        System.out.println(s1464.maxProduct(intArray));
        System.out.println(s2706.buyChoco(intArray, 3));
    }
}
