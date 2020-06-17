/**
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：因为要求使用O(1)空间   不使用额外的数组
     * 反转数组我们发现反转位置的两个字符下标和为s.length-1
     * 因此我们考虑不反转数组  将相应的字符坐标反转即可
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i=0;
        int j=s.length-1;
        /*for (i = 0,j=s.length-1; i < (s.length + 1)/2; i++,j--) {
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
        或者使用while循环
        */
        while (i < j) {
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

