import com.sun.prism.shader.AlphaOne_LinearGradient_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：没有排好序
     * 将nums1数组存放如HashMap集合中   对nums2数组从左往右遍历
     * 如果HashMap中存在nums2对应的数据且数量》0   则这个数为其中的一个交集,对应的map中数量-1   将他存入list集合中
     * 不相等则比较下一位   如果全不相等  则输出[]
     *
     * @param nums1
     * @param nums2
     * @return

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
                continue;
            }
            map.put(nums1[i], 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
     */
    /**
     * 方法二：先排序再求交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        quickSort(nums1,0,nums1.length-1);
        quickSort(nums2,0,nums2.length-1);
        List<Integer> list=new ArrayList<Integer>();
        int i=0;
        int j=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for (int m = 0; m < len; m++) {
            ans[m] = list.get(m);
        }
        return ans;
    }

    /**
     * 快速排序   从小到大
     * 我们考虑以数组中间的数作为依据进行快排
     * @param arr 待排数组
     * @param left 左下标
     * @param right 右下标
     * @return
     */
    public void quickSort(int[] arr,int left,int right){
        if (arr == null) {
            return ;
        }
        int L=left;
        int R=right;
        int mid=arr[(left+right)/2];
        while (left < right) {
            while (arr[left] < mid) {
                left++;
            }
            while (arr[right] > mid) {
                right--;
            }
            if (left <= right) {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        if (L < right) {
            quickSort(arr,L,right);
        }
        if (left < R) {
            quickSort(arr,left,R);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

