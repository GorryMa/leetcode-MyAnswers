/**
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i
//+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 44 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        /**
         * 方法一：依次相乘  乘到i时跳过   超出时间限制

        int[] ans=new int[a.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=1;
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    continue;
                }
                ans[i]=ans[i]*a[j];
            }
        }
        return ans;
         */
        /**
         * 方法二：使用动态规划  该点处的值等于左侧的乘积和乘以右侧的乘积和
         */
        if (a.length == 0 || a == null) {
            return new int[0];
        }
        int[] ans=new int[a.length];
        ans[0]=1;
        int temp=1;
        for (int i = 1; i < a.length; i++) {
            ans[i]=ans[i-1]*a[i-1];
        }
        for (int i = a.length-2; i>=0 ; i--) {
            temp=temp*a[i+1];
            ans[i]=ans[i]*temp;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

