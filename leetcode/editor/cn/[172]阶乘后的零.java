import java.math.BigInteger;

/**
//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：  使用阶乘和java.math.BitInteger类进行计算   报错
     *
     * @param n
     * @return public int trailingZeroes(int n) {
     * // Calculate n!
     * BigInteger nFactorial = BigInteger.ONE;
     * for (int i = 2; i <= n; i++) {
     * nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
     * }
     * // Count how many 0's are on the end.
     * int zeroCount = 0;
     * <p>
     * while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
     * nFactorial = nFactorial.divide(BigInteger.TEN);
     * zeroCount++;
     * }
     * return zeroCount;
     * }
     */
    /**
     * 方法二：
     * 我们发现要实现末尾为0的条件是阶乘中间乘以一个10  他由偶数*5或者一个单独的10的倍数组成
     * 显然可以5！=1*2*3*4*5 满足条件
     * 即我们只需要分析该数中有几对[2,5]既可以判断末尾5！包含的0的个数，偶数的个数远大于5的个数
     * 即我们只需要判断（包括该数）该数之间能够被5整除几次就可以判断有几个5
     * 值得注意的是  当
     * @param n
     * @return

    public int trailingZeroes(int n) {
        int ans=0;
        for (int i = 5; i <=n ; i=i+5) {
            int x=i;
            while (x % 5 == 0) {
                ans++;
                x=x/5;
            }
        }
        return ans;
    }
     */
    /**
     * 方法三：
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans=0;
        long x=5;
        while (n >= x) {
            ans+=(n/x);
            x=x*5;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

