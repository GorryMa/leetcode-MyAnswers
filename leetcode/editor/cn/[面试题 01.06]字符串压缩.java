/**
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串 
// 👍 51 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String compressString(String S) {
        /**
         * 方法一：从头到尾遍历   超时

        if (S == null || S.length() <=2) {
            return S;
        }
        StringBuilder stringBuilder=new StringBuilder();
        int count=1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(S.charAt(i-1)).append(count);
                count=1;
            }
            if (i == S.length() - 1) {
                stringBuilder.append(S.charAt(i)).append(count);
            }
        }
        if (S.length() > == stringBuilder.toString().length()) {
            return S
        }else {
            return stringBuilder.length();
        }
         */
        /**
         * 方法二：
         */
        int N = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            int j = i;
            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

