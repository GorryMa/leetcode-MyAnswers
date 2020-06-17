import java.util.ArrayList;
import java.util.List;

/**
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 128 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        /**
         * 方法一：逐层循环

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        List<Integer> list=new ArrayList<Integer>();
        int[] ans=new int[rows*columns];
        int left=0,right=columns-1,up=0,down=rows-1;
        while (left<=right&&up<=down){
            for (int i = left; i <=right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up+1; i <=down ; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && up < down) {
                for (int i = right-1; i >left ; i--) {
                    list.add(matrix[down][i]);
                }
                for (int i = down; i >up ; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        for (int i = 0; i <ans.length  ; i++) {
            ans[i]=list.get(i);
        }
        return ans;
         */
        /**
         * 方法二：
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

