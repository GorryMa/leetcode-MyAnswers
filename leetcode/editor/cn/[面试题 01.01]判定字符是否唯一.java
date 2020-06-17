import java.util.HashSet;
import java.util.*;
/**
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 54 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        /**
         * 方法一：使用HashSet存储元素判断两个长度是否相等

        if (astr == null || astr.length() == 0) {
            return true;
        }
        Set<Character> set=new HashSet<Character>();
        for (int i = 0; i < astr.length(); i++) {
            set.add(astr.charAt(i));
        }
        return astr.length()==set.size();
         */
        /**
         * 方法二：双重循环判断是否有重复
         */
        if (astr == null || astr.length() == 0) {
            return true;
        }
        for (int i = 0; i < astr.length() - 1; i++) {
            for (int j = i+1; j < astr.length(); j++) {
                if (astr.charAt(i)==astr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
        /**
         * 方法三：使用indexOf（）和lastIndexOf（）判断是否是同一位置  不是同一位置  则存在重复 输入false
         */
        /**
         * 方法四：使用位运算
         */
        public boolean isUnique(String astr) {
            long low64 = 0;
            long high64 = 0;

            for (char c : astr.toCharArray()) {
                if (c >= 64) {
                    long bitIndex = 1L << (c - 64);
                    if ((high64 & bitIndex) != 0) {
                        return false;
                    }

                    high64 |= bitIndex;
                } else {
                    long bitIndex = 1L << c;
                    if ((low64 & bitIndex) != 0) {
                        return false;
                    }

                    low64 |= bitIndex;
                }

            }

            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

