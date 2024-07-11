class Solution1190 {
  public String reverseParentheses(String s) {
    int idxStart = 0;
    int idxEnd = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        idxStart = i;
      }

      if (s.charAt(i) == ')') {
        idxEnd = i;
        break;
      }
    }

    if (idxStart == 0 && idxEnd == 0)
      return s;

    String strFragment = s.substring(idxStart + 1, idxEnd);
    String reversed = new StringBuilder(strFragment).reverse().toString();
    String replaced = s.replace("(" + strFragment + ")", reversed);

    return reverseParentheses(replaced);
  }

  public static void main(String[] args) {
    Solution1190 solution = new Solution1190();

    // System.out.println(solution.reverseParentheses("(abcd)"));
    System.out.println(solution.reverseParentheses("(u(love)i)"));
  }
}
