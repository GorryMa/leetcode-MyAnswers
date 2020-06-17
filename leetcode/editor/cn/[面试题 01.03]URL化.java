/**
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
//
// 示例1: 
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 
//
// 示例2: 
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 500000]范围内。 
// 
// Related Topics 字符串 
// 👍 18 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {
        /**
         * 方法一：依次循环遍历

        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i)==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
         */
        /**
         * 方法二：调用replaceAll（）方法全部替换然后截取
         */
        String s = S.substring(0,length).replaceAll(" ","%20");
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

