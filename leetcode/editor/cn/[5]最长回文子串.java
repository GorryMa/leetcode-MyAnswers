/**给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"  "sdfujkhohkjuvd"
//输出: "bb"
*/
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*** 方法一：暴力解法，先判断是否是回文串，然后依次判断大小
    public String longestPalindrome(String s) {
        String str=null;
        if (s.length()<2){
            return s;
        }
        char[] array = s.toCharArray();
        int maxSize=0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if ((isPalindrome(array,i,j))&&(s.substring(i,j+1).length()>maxSize)){
                    str=s.substring(i,j+1);
                    maxSize=str.length();
                }
            }
        }
        return str;
    }

    public boolean isPalindrome(char[] array,int left,int right) {
        boolean flag=true;
        while (left<right){
            if (array[left]!=array[right]){
                flag=false;
            }
            left++;
            right--;
        }
        return flag;
    }
     *
     */
    /**
     * 方法二：动态规划
     * 若str=s.substring(i,j+1)为回文子串，且s.chatAt(i-1)==s.chat(j+1),则s.substring(i-1,j+2)也为回文子串
     * 用flag[i][j]=true表示s.substring（i，j+1）为回文子串，在这个基础上判断s.chatAt(i-1)？=.chat(j+1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
