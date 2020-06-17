import java.util.*;

/**
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值至多为 k。
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 201 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
         * 方法一：暴力法双指针寻找
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <=i + k&&j<nums.length; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
         */
        /**
         * 方法二：使用HashMap存储数值和此时下标

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i-map.get(nums[i])<= k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
         */
        /**
         * 方法三：使用HashSet来存储
         */
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

