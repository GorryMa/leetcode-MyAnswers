/**
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 87 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        /**
         * 方法一：若x+y<=y+x  则x比y小
         */
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; ++i)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,(o1,o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

