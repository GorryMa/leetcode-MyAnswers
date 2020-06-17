/**
//桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。 
//
// 示例 1： 
//
// 
// 输入：[4,2,1] 
//
// 输出：4 
//
// 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。 
// 
//
// 示例 2： 
//
// 
// 输入：[2,3,10] 
//
// 输出：8 
// 
//
// 限制： 
//
// 
// 1 <= n <= 4 
// 1 <= coins[i] <= 10 
// 
//

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：因为每次只能选取一堆   所以总的最小次数即为堆的最小次数和  每堆最多可以拿2个最少拿1个  所以每堆的最小次数即为（coins[i]+1）/2；
     * @param coins
     * @return
     */
    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int ans=0;
        for (int i = 0; i < coins.length; i++) {
            ans+=(coins[i]+1)/2;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

