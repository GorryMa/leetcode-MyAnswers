/**
//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：使用位运算
     * 对于二进制的加法运算，若不考虑进位，则1+1=0,1+0=1,0+1=1,0+0=0,通过对比异或，不难发现，此方法与异或运算类似。因而排出进位，加法可用异或来实现。
     * 然后考虑进位，0+0进位为0,1+0进位为1,0+1进位为0，1+1进位为1，该操作与位运算的&操作相似。
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a|b;
        }
        int s=a^b;
        int carry=(a&b)<<1;
        return add(s,carry);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

