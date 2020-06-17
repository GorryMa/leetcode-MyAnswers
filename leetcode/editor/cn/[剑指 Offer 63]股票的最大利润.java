/**
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 动态规划 
// 👍 52 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 方法一：使用两个循环来求差的最大值 则0<=买入时间<卖出时间<==prices.length-1

        int ans=0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > ans) {
                    ans=prices[j]-prices[i];
                }
            }
        }
        return ans;
         */
        /**
         * 方法二:使用dp[i]表示以i下标结尾的数组的最大利润   min表示最小数下标的位置
         * 且0<=left<right<=prices.length-1

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp=new int[prices.length];
        dp[0]=0;
        int min=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<=prices[min]){
                min=i;
            }
            if (prices[i]-prices[min]>dp[i-1]){
                dp[i]=prices[i]-prices[min];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[prices.length-1];
         */
        /**
         * 方法三：动态规划简化
         */
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

