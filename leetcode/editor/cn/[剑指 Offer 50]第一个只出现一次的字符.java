import java.util.HashMap;
import java.util.*;
/**
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 41 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        /**
         * 方法一：将数据存到hashmap中  key为数值  value为次数
         */
        Map<Character,Boolean> map=new HashMap<Character, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),false);
                continue;
            }
            map.put(s.charAt(i),true);
        }
        for (char a :s.toCharArray() ) {
            if (map.get(a)) {
                return a;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

