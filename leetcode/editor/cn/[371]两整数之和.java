/**
//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：考虑位运算
     * 两数之和  实际上等于两数非进位运算结果+进位结果
     * 两数非进位运算结果   1+0=1/1+1=0/0+0=0/0+1=1       实际上是异或运算
     * 考虑进位结果        0+0进位为0/0+1进位为0/1+0进位为0/1+1进位为1   实际上是与运算  但要注意的是  由于是进位  所以要左移一位
     * 对于非进位结果和进位结果  仍然执行的加法运算  即异或运算  直到不存在进位
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp=a^b;
            b=(a&b)<<1;
            a=temp;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

