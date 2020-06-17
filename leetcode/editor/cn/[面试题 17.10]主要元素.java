import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：利用HashMap计算每个数出现的次数  当次数大于数组长度一半时   输出
     *
     * @param nums
     * @return

    public int majorityElement(int[] nums) {
        int ans = -1;
        int mid = nums.length / 2;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                continue;
            }
            map.put(nums[i], 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > mid) {
                ans=key;
                break;
            }
        }
        return ans;
    }
     */
    /**
     * 方法二：由题意可知  主要元素的个数count>nums.length/2   即主要元素的个数大于其他元素的个数和
     * 因此，我们假定nums[0],即为主要元素，此时count=1，当下一个元素相等count加一，保持元素不变，不同时count减一
     * 当count=0时   我们定义下一个元素为所求元素  重复上述步骤
     * 若存在主要元素  则count一定>0   若没有count>0  则不存在主要元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans=nums[0];
        int count=1;
        for (int i = 1; i < nums.length ; i++) {
            if (count == 0) {
                ans=nums[i];
                count=1;
                continue;
            }
            if (ans==nums[i]){
                count++;
            }else {
                count--;
            }
        }
        if (count > 0) {
            return ans;
        }else {
            return -1;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

