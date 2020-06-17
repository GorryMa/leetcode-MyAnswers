/**
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：暴力法   (超时)

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans=nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                ans=Math.max(ans,preSum(nums,i,j));
            }
        }
        return ans;
    }
     */

    /**
     * 求数组nums下标为left-right的数据的和
     * @param nums
     * @param left
     * @param right
     * left<=right
     * @return

    public int preSum(int[] nums,int left,int right){
        int sum=0;
        for (int i = left; i <right+1; i++) {
            sum+=nums[i];
        }
        return sum;
    }
    */
    /**
     * 方法二：动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length=nums.length;
        //定义 dp[i] 为以 i 结尾子串的最大值
        int[] dp=new int[length];
        dp[0]=nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
        }
        int ans=nums[0];
        for (int i = 1; i < length; i++) {
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

