import java.util.HashSet;
import java.util.Set;

/**
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 二分查找 分治算法 
// 👍 379 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 方法一：Set集合或ArrayList集合

        Set<Integer> set=new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                set.add(matrix[i][j]);
            }
        }
        if (set.contains(target)){
            return true;
        }
        return false;
         */
        /**
         * 方法二：依次寻找  从右上角开始  当target<num时   左移  否则下移  直到到达边界或者num==target
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

