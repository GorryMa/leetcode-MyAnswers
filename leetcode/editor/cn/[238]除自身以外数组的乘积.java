/**
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：暴力法   超时   不满足O(n)时间复杂度
     * @param nums
     * @return

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return null;
        }
        int[] ans=new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=1;
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                ans[i]=ans[i]*nums[j];
            }
        }
        return ans;
    }
     */
    /**
     * 方法二：一个数的除它的乘积就是它左侧乘积*右侧乘积
     * @param nums
     * @return

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return null;
        }
        int[] ans=new int[nums.length];
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i]=left[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i >=0; i--) {
            right[i]=right[i+1]*nums[i+1];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
     */
    /**
     * 方法三：空间复杂度为O(1)
     * 抛弃左右数组数组  先用ans数组算出左数组的值  然后从右往左依次相乘可以算出数组的值
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return null;
        }
        int[] ans=new int[nums.length];
        ans[0]=1;
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]*nums[i-1];
        }
        int right=1;
        for (int i = nums.length-1; i >=0; i--) {
            ans[i]=ans[i]*right;
            right=right*nums[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

