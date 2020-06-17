/**
//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
// 
//
// 示例2: 
//
// 
// 输入：num = 3
// 输出：3
// 
//
// 提示: 
//
// 
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。 
// 
// Related Topics 位运算 
// 👍 27 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int exchangeBits(int num) {
        /**
         * 方法一：
         * 0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
         *
         * 0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
         *
         * 0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
         *
         * 0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)
         *
         * 0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
         *
         * 0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
         *
         * 则num&0xaaaaaaaa得到所有偶数位的1的个数     num&0x55555555得到所有奇数位1的个数
         */
        //奇数位
        int odd=num&0x55555555;
        //偶数位
        int even=num&0xaaaaaaaa;
        //奇数位左移一位，偶数位右移一位
        odd=odd<<1;
        even=even>>1;
        return odd|even;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

