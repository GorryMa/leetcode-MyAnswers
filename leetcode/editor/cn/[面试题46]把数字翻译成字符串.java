/**
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2的31次方
// 
//

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划，首先将int转为字符串方便求每个位的值
     * 对于一个长度为i的字符串，则它的翻译方法=前i-1为的翻译方法
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num <= 0) {
            return 0;
        }
        String s = String.valueOf(num);
        if (s.length() <= 1) {
            return 1;
        }
        //dp[i]表示从左往右数以第i为数字结尾的字符串的翻译方法
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        char[] chars = s.toCharArray();
        for (int i = 2; i < chars.length+1; i++) {
            dp[i]=dp[i-1];
            int n = chars[i - 1] - '0';
            int m = (chars[i - 2] - '0') * 10;
            int x=m+n;
            if (x >= 10 && x <= 25) {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

