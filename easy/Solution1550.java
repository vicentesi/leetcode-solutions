class Solution1550 {
  public boolean threeConsecutiveOdds(int[] arr) {
    int oddCounter = 0;

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] % 2 != 0) {
        oddCounter++;
      } else {
        oddCounter = 0;
      }

      if (oddCounter == 3)
        return true;
    }

    return false;
  }

  public static void main(String[] args) {
    Solution1550 obj = new Solution1550();
    
    System.out.println(obj.threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
    System.out.println(obj.threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
  }
}

/*
  * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
  *
  * Example 1:
  * Input: arr = [2,6,4,1]
  * Output: false
  * Explanation: There are no three consecutive odds.
  *
  * Example 2:
  * Input: arr = [1,2,34,3,4,5,7,23,12]
  * Output: true
  * Explanation: [5,7,23] are three consecutive odds.
  *
  * Constraints:
  * 1 <= arr.length <= 1000
  * 1 <= arr[i] <= 1000
  *
  */