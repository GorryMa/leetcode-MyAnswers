package com.leetcode.editor.cn;
/**
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串

*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：利用String的 split（“字符”）分割字符串得到一个String类型的数组  输出数组最后一个的长度
     * 如果数组全为" ",则得到的数组长度为0  此时输出0
     * 否则，我们以" "分割，得到的数组末尾一定为字符串
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arrS = s.split(" ");
        if (arrS.length == 0) {
            return 0;
        }
        return arrS[arrS.length-1].length();
    }
}