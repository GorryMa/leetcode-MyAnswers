import java.util.List;

/**
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 34 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        /**
         * 方法一：创建两个新数组  一个存放奇数一个存放偶数  最后把偶数组存放到奇数组后面

        if (nums.length == 0 || nums == null) {
            return nums;
        }
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                list2.add(nums[i]);
            }else {
                list1.add(nums[i]);
            }
        }
        list1.addAll(list2);
        int[] ans=new int[nums.length];
        for (int i = 0; i < list1.size(); i++) {
            ans[i]=list1.get(i);
        }
        return ans;
         */

        /**
         * 方法二：快排变形
         */

    }
}
//leetcode submit region end(Prohibit modification and deletion)

