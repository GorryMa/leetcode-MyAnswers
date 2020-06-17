/**
//给定一个整数数组，找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 40 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        /**
         * 方法一：动态规划
         */
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i]=nums[i];
            }else {
                dp[i]=dp[i-1]+nums[i];
            }
        }
        int ans=dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > ans) {
                ans=dp[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

