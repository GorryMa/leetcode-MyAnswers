/**
//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
// 返回的长度需要从小到大排列。 
// 示例： 
// 输入：
//shorter = 1           2             3
//longer = 2            4             4
//k = 3                 3             5
//输出： {3,4,5,6}      [6,8,10,12]  [15,16,17,18,19,20]
// 
// 提示： 
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (shorter == longer) {
            int[] ans=new int[1];
            ans[0]=shorter*k;
            return ans;
        }
        int[] ans=new int[k+1];
        //x表示两个长度的差
        int x=longer-shorter;
        ans[0]=shorter*k;
        ans[k]=longer*k;
        for (int i = 1; i <k ; i++) {
            ans[i]=ans[i-1]+x;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

