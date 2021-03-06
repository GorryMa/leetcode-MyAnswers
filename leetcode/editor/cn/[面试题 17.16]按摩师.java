import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例 1： 
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
// 
//
// 示例 3： 
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
// 
// Related Topics 动态规划

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：动态规划
     * 使用一个HashMap集合存放每个dp[i]的值   key为i  value为dp[i]
     * dp[i]表示当取到下标为i时的最大总时长  则dp[i]=Math.max（dp[i-1],dp[i-2]+num[i]);
     * 出口为dp[0]  和dp[1]

    public int massage(int[] nums) {
        //dp[i]表示当取到下标为i时的最大总时长
        int[] dp=new int[nums.length];
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        dp[0]=nums[0];
        map.put(0,dp[0]);
        dp[1]=Math.max(nums[0],nums[1]);
        map.put(1,dp[1]);
        for (int i = 2; i <nums.length; i++) {
            if (map.containsKey(i)){
                dp[i]=map.get(i);
                break;
            }
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            map.put(i,dp[i]);
        }
        return dp[nums.length-1];
    }
     */
    /**
     * 方法二：优化
     * 当i>=2时 则dp[i]=Math.max（dp[i-1],dp[i-2]+num[i]);
     * 实际上我们只需要存前两个最大值就行   然后依次替换
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int ans=0;
        int a=nums[0];
        int b=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length; i++) {
            ans=Math.max(a+nums[i],b);
            a= b;
            b=ans;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

