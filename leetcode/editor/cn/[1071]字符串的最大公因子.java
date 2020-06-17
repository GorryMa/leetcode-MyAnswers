/**
//对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。 
//
// 
//
// 示例 1： 
//
// 输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 字符串

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：先求每个字符串的最小重复字符串  再求相同的最大重复字符串
     * @param str1
     * @param str2
     * @return

    public String gcdOfStrings(String str1, String str2) {
        String s1=getRepeatedString(str1);
        String s2=getRepeatedString(str2);
        if (!s1.equals(s2)) {
            return "";
        }
        if (str1.length() % str2.length() == 0) {
            return str2;
        }
        if (str2.length() % str1.length() == 0) {
            return str1;
        }
        int i = getMaxRepeatedNumber(str1.length(), str2.length());
        if (i != 1) {
            return str1.substring(0,i);
        }
        return s1;
    }

    /**
     * 求两个数的最大公约数
     * @param a
     * @param b
     * @return

    public int getMaxRepeatedNumber(int a,int b){
        int ans=1;
        if (a == b) {
            return a;
        }
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        if (max > min) {
            while (max % min != 0) {
                ans=max%min;
                max=min;
                min=ans;
            }
        }
        return ans;
    }
    /**
     * 求一个字符串的最短重复字符串
     * 定义一个left指针 一个right指针  则str=s.substring(0,left+1)为第一个字符串  s.substring(left+1,s.right)为第二个字符串
     * @param s
     * @return

    public String getRepeatedString(String s){
        if (s.length()==0||s.equals("")){
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        for (int i = 1; i <=s.length()/2 ; i++) {
            String s1=s.substring(0,i);
            int j=i;
            while (j<s.length()) {
                String s2=s.substring(j,j+s1.length());
                //s1.equals(s2)&&s.length()%s2.length()==0
                if (s1.equals(s2)){
                    j=j+s1.length();
                }
                if (j == s.length()) {
                    return s1;
                }
                if (!s1.equals(s2)||j>s.length()) {
                    break;
                }
            }
        }
        return s;
    }
     */
    /**
     * 方法二：优化   若两个字符串的最大公因子不为"",则两个字符串肯定都是由同一个字符串拼接而成的   如"ABCABCABC"和"ABC"   则
     * str1+str2=str2+str1
     * 因此首先判断str1+str2=str2+str1？？？？    是的话求两个字符串长度的最大公约数然后得到最大公因子  否的话直接输出""
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if ((str1+str2).equals(str2+str1)){
            int i = getMaxRepeatedNumber(str1.length(), str2.length());
            return str1.substring(0,i);
        }
        return "";
    }

    /**
     * 求两个数的最大公约数
     * @param a
     * @param b
     * @return
     */
    public int getMaxRepeatedNumber(int a,int b){
        int ans=1;
        if (a % b == 0) {
            return b;
        }
        while (a % b != 0) {
            ans=a%b;
            a=b;
            b=ans;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

