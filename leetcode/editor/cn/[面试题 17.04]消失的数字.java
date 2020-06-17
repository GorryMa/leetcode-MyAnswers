import java.util.ArrayList;
import java.util.List;

/**
//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？ 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例 1： 
//
// 输入：[3,0,1]
//输出：2 
//
// 
//
// 示例 2： 
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
// 
// Related Topics 位运算 数组 数学

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：对0-n共n+1个数   和为s=（0+n）*（n+1)/2
     * 若缺少其中的数x  则和s变为s-x
     * 因此我们只需算出数组各项的和与前n项和作比较   差即为所求值
     * @param nums
     * @return

    public int missingNumber(int[] nums) {
        int sumN=0;
        int sumNums=0;
        for (int i = 0; i < nums.length; i++) {
            sumNums+=nums[i];
        }
        for (int i = 0; i <=nums.length; i++) {
            sumN+=i;
        }
        return sumN-sumNums;
    }
     */
    /**
     * 方法二：使用两个list集合分别存放前n+1项  数组各项值   则前n+1项不包括的数字即为所求数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        List<Integer> listN=new ArrayList<Integer>();
        List<Integer> listNums=new ArrayList<>();
        for (int i = 0; i <=nums.length; i++) {
            listN.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            listNums.add(nums[i]);
        }
        listN.removeAll(listNums);
        return listN.get(0);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

