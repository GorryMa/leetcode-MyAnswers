/**
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 方法一：冒泡算法   依次比较进行填写
         */
        int[] ans=new int[m+n];
        int i=0;
        int j=0;
        while (i < m && j < n) {
            if (nums1[i]<=nums2[j]){
                ans[i+j]=nums1[i];
                i++;
            }else {
                ans[i+j]=nums2[j];
                j++;
            }
        }
        if (i == m) {
            for (int k = j; k <n ; k++) {
                ans[k+m]=nums2[k];
            }
        }
        if (j==n){
            for (int l = i; l <m ; l++) {
                ans[l+n]=nums1[l];
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k]=ans[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

