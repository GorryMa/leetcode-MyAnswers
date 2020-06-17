import java.util.Arrays;

/**
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 166 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        /**
         * 方法一：调用Arrays.sort

        Arrays.sort(nums);
        return nums;
         */
        /**
         * 方法二：冒泡排序
         * n个数字比较n-1趟 比较次数从n-1次到1次递减
         * 冒泡排序升序排序先排最大再排最小
         */
        for (int i = 0; i < nums.length-1; i++) {

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

