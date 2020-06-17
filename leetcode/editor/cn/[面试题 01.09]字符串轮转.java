/**
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 
// 👍 34 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        /**
         * 方法一：若s2是由s1宣传成的   则把s2拼接一次  其中必含有s1
         */
        if (s1.length() != s2.length()) {
            return false;
        }
        String S=s2+s2;
        if (S.contains(s1)) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

