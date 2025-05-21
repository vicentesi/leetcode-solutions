import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer[]> initial0 = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    initial0.add(new Integer[]{i, j});
                }
            }
        }

        for (Integer[] pair : initial0) {
            for (int x = 0; x < n; x++) {
                matrix[pair[0]][x] = 0;
            }

            for (int y = 0; y < m; y++) {
                matrix[y][pair[1]] = 0;
            }
        }   
    }

    public static void main(String[] args) {
        Solution73 solution = new Solution73();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

/*
 * 73. Set Matrix Zeroes
 * 
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */