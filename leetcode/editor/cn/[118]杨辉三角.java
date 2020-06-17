import java.util.ArrayList;
import java.util.List;

/**
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：暴力法      每个数等于它前一行的坐标减一处的数和前一行相同坐标的数的和
     * 双层循环依次添加
     * 递归出口为numRows=1和numRows=2
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        //外层表示第几行
        for (int i = 0; i < numRows; i++) {
            //内存表示第几个
            List<Integer> list=new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i||i==0||i==1) {
                    list.add(1);
                }else {
                    list.add(listList.get(i-1).get(j-1)+listList.get(i-1).get(j));
                }
            }
            listList.add(list);
        }
        return listList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

