/**
//设计一个算法，算出 n 阶乘有多少个尾随零。 
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
    public int trailingZeroes(int n) {
        /**
         * 方法一：若尾数有0  即从1-n中有成对的2和5出现或者有10的倍数出现
         * 每出现一对2和5  结果有一个0  出现一个10结果一个0
         * 因为有5出现则一定有偶数出现即一定有2出现  所以我们实际上只需要算有多少5出现即可
         * 当出现5的倍数时  计算有几个5出现 即25实际上有两个5出现
         */
        int ans=0;
        while (n >= 5) {
            n=n/5;
            ans+=n;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

