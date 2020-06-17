import java.util.HashMap;
import java.util.Map;
/**
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 62 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //public int search(int[] nums, int target) {
        /**
         * 方法一：利用HashMap存储数字的值和次数  然后求返回值

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                continue;
            }
            map.put(nums[i],1);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }else {
            return 0;
        }
         */
        /**
         * 方法二：逐次查找

        int ans=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == target) {
                ans++;
            }
        }
        return ans;
         */
        /**
         * 方法三：二分法
         * 初始化：low = 0, high = nums.length - 1.low=0,high=nums.length−1.
         * 当low≤high时递归二分查找：
         * mid = (low + high) / 2mid=(low+high)/2
         * 若nums[mid] == targetnums[mid]==target，[low, mid - 1][low,mid−1]和[mid + 1, high][mid+1,high]都有可能还有targettarget，因为存在重复元素，继续递归查找。
         * 若nums[mid] < targetnums[mid]<target，说明targettarget只可能出现在区间[mid + 1, high][mid+1,high]，继续递归查找。
         * 若nums[mid] > targetnums[mid]>target，说明targettarget只可能出现在区间[low, mid - 1][low,mid−1]，继续递归查找。
         * 算法结束，返回计数器的值
         *
         */
        int cnt = 0;    // 计数器count
        public int search(int[] nums, int target) {
            // 初始化low = 0, high = nums.length - 1
            helper(nums, target, 0, nums.length - 1);
            return cnt;
        }
        // 根据算法设计分3种情况
        public void helper(int[] nums, int target, int low, int high) {
            if (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target) {
                    cnt++;      // 计数一次
                    helper(nums, target, low, mid - 1);
                    helper(nums, target, mid + 1, high);
                } else if (nums[mid] > target) {
                    helper(nums, target, low, mid - 1);
                } else {
                    helper(nums, target, mid + 1, high);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

