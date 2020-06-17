import java.util.HashMap;
import java.util.Map;

/**
//珠玑妙算游戏（the game of master mind）的玩法如下。 
// 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽
//4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
//注意，“猜中”不能算入“伪猜中”。 
// 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[
//1]为伪猜中的次数。 
// 示例： 
// 输入： solution="RGBY",guess="GGRR"
//输出： [1,1]
//解释： 猜中1次，伪猜中1次。
// 
// 提示： 
// 
// len(solution) = len(guess) = 4 
// solution和guess仅包含"R","G","B","Y"这4种字符 
// 
// Related Topics 数组

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：如果下标和字符均一致  猜中次数加1
     * 否则，将对应的solution和guess数组对应的值存入两个数组中，其中数组的下标为该字符对应的ASK码与‘A'ASk码的差值
     * 'A'下标为0  ’Z'下标为25   数组长度为26
     * 此时两个数组相同下标对应的非零数字的较小值即为伪猜中数
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {
        int[] ans=new int[2];
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        if (solution == null || guess == null || solution.length() != guess.length()) {
            return ans;
        }
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ans[0]+=1;
            }
            else {
                arr1[solution.charAt(i)-'A']++;
                arr2[guess.charAt(i)-'A']++;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                ans[1]+=Math.min(arr1[i],arr2[i]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

