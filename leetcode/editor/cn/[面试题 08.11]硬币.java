/**
//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划 
// 👍 171 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int waysToChange(int n) {
        *//**
         * 方法一：动态规划   完全背包问题
         *//*
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;
        */
        /**
         * dp方程：dp[i] += dp[i - coin];
         */
        /*
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}*/
class Solution {
    /**
     * 方法 1 ： 二维 dp 比较直观的解法
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];  // 一般多开一个位置，0 空着不用
        // base case
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                // 下面👇这部分代码是可以进一步改写的，因为从状态转移方程里面可以看到都有 dp[i-1][j],
                // 因此可以直接不用判断就赋值给 dp[i][j]，判断后再加上『 选择当前硬币时 』的补偿值就可以了

                if (j - coins[i-1] < 0){                   // 要组成的面值比当前硬币金额小，该硬币不可以选择
                    dp[i][j] = dp[i - 1][j] % 1000000007;  // 只能由 i - 1 中硬币来组成面值 j
                } else {
                    // 当前硬币可以不选，也可以选择
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i-1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    /**
     * 方法 2 ： 进一步一维 dp ，从状态转移方程可以看出，dp[i][j] 仅仅和 dp[i-1]的状态有关，所以可以压缩为 1 维
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

