import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

/**
//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 32 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        /**
         * 方法一：使用一个HashSet来存放数据  每个字符第一次出现存入  再次出现移出  直至最后set数组长度为0或1
         */
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                continue;
            }
            set.add(s.charAt(i));
        }
        return set.size()<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

