import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 方法一：双层循环嵌套找出所有的依次以i开头的不含重复字符的子串，然后求出最大值

        List<String> list=new ArrayList<>();
        int temp=0;
        int maxSize=0;
        if (s.length()==0||s==null){
            return maxSize;
        }
        if (s.length()==1){
            return 1;
        }
        for (int i = 0; i < s.length()-1;i++) {
            for (int j = i+1; j <s.length() ; j++) {
                String s1=s.substring(i,j);
                if (s1.contains(String.valueOf(s.charAt(j)))) {
                    s1 = s.substring(i, j);
                    list.add(s1);
                    break;
                }
                if (j==s.length()-1){
                    s1=s.substring(i,j+1);
                    list.add(s1);
                    break;
                }
            }
        }
        maxSize=list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length()>maxSize){
                maxSize=list.get(i).length();
            }
        }
        return maxSize;
         */
        /**
         * 方法二：利用hashMap求解降低时间复杂度
         }*/
        int maxSize=0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            maxSize = Math.max(maxSize, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

