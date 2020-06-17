import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"     "abcccgcddfffghhhijjj"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        /**
         * 方法一：算出所有字符出现的的次数
         * 利用hashmap存储  key为字符值  value为出现的次数
         * 若全为偶数  则总长度为偶数和
         * 若存在奇数，则总长度为偶数和+必奇数小一的偶数和+1
         *
         */
        int ans=0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                continue;
            }
            map.put(s.charAt(i),1);
        }
        Object[] objects = map.keySet().toArray();
        for (int i = 0; i < objects.length; i++) {
            int n=map.get(objects[i]);
            if (n%2==0) {
                ans+=n;
                continue;
            }
            if (n %2 != 0 && ans%2==0) {
                ans+=1;
                continue;
            }
            if (n>2) {
                ans+=n-1;
                continue;
            }
        }
        return ans;
        /**
         * 方法二：利用HashSet存储字符值
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

