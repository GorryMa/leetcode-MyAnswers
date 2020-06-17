/**
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"      "hjabkajh"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：超出时间限制
    public boolean validPalindrome(String s) {
        boolean flag=false;
        char[] chars = s.toCharArray();
        if (chars.length==1||chars.length==2){
            return true;
        }
        int left=0;
        int right=chars.length-1;
        while (left < right) {
            if (chars[left]==chars[right]){
                left++;
                right--;
                if (left == right||right-left==1) {
                    flag=true;
                    break;
                }
            }
            if (chars[left]==chars[right-1]||chars[left+1]==chars[right]){
                left++;
                right--;
                if (right-left==1){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
     }
         */
        /**
         * 方法二：双指针递归
         */
    public boolean validPalindrome(String s) {
        if (s.length()<=2) {
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else {
                boolean flag1=true,flag2=true;
                for (int i = left,j=right-1; i <j ; i++,j--) {
                    if (s.charAt(left) != s.charAt(right)) {
                        flag1=false;
                        break;
                    }
                }
                for (int i = left+1,j=right; i <j ; i++,j--) {
                    if (s.charAt(left) != s.charAt(right)) {
                        flag1=false;
                        break;
                    }
                }
                return flag1||flag2;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

