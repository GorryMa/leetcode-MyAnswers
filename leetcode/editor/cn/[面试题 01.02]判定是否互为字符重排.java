import java.util.*;

/**
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 16 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        /**
         * 方法一：
         */
        int l1=s1.length(),l2=s2.length();
        if(l1!=l2)
            return false;
        int []index=new int[128];
        for(int i=0;i<l1;i++){
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for(int i=0;i<128;i++){
            if(index[i]!=0)
                return false;
        }
        return true;
        /**
         * 方法二：将两个个字符串排序后比较是否一致

        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

