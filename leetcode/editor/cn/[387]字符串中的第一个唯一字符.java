import java.util.HashMap;
import java.util.Map;
/**
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：利用hashmap记录每个字符和它出现的下标  当不是第一次出现时  更新key值为-1，最后输出表中所有坐标的最小值即为所求
     * 若s中所有字符均没有重复出现  则下标为0
     * 当有坐标重复出现  更新为最新坐标
     * 最后hashmap表中所有坐标的最小值（！=-1）就是所求
     * 若所有值均为-1  输出-1
     *
     * @param s
     * @return

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
                continue;
            }
            map.put(s.charAt(i), i);
        }
        int ans = -1;
        for (char key : map.keySet()) {
            if (map.get(key) != -1 && ans == -1) {
                ans = map.get(key);
            }
            if (map.get(key) != -1 && map.get(key) < ans) {
                ans = map.get(key);
            }
        }
        return ans;
    }
     */
}
//leetcode submit region end(Prohibit modification and deletion)

