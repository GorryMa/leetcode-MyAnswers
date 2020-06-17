/**
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        /**
         * 方法一：暴力法  双层循环
         * 执行用时 :399 ms, 在所有 Java 提交中击败了5.07%的用户
         * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了6.67%的用户

        int ans=nums[0];
        outer: for (int i = 0; i < nums.length - 1; i++) {
            inner: for (int j = i+1; j <nums.length; j++) {
                if (nums[i]==nums[j]){
                    ans=nums[i];
                    break outer;
                }
            }
        }
        return ans;
         */
        /**
         * 方法二：快慢指针     (参考141/142题）
         * 由题目可知  nums的长度为n+1,即nums的下标为0<=i<=n  且任意的nums[i]<=n
         */
        int slow=0;
        int fast=0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

