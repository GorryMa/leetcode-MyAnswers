/**
//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 9 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int convertInteger(int A, int B) {
        /**
         * 方法一：考虑使用位运算
         * 由异或规则可知 相同得0，不同得1 若两个数相等  异或结果为0
         * 因此A异或B  得到的一个数temp  我们只需要求temp中所有为1的位有多少个即可
         *
         */
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);  // 去掉二进制表示的最右边的1
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

