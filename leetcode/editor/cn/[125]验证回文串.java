/**
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 256 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        /**
         * 方法一：默认为true  从两头往中间比较  当出现空 ,或者：时比较下一位  直至left==right

        if (s.isEmpty()) {
            return true;
        }
        boolean flag=true;
        int left=0;
        int right=s.length()-1;
        while (left < right) {
            while (left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
         */
        /**
         * 方法二：去除原字符串的非数字和字符并进行得到新字符串   比较新字符串和其反转字符串是否相等
         */
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuffer.append(Character.toLowerCase(c));
            }
        }
        String string = stringBuffer.toString();
        String string1 = stringBuffer.reverse().toString();
        return string.equals(string1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

