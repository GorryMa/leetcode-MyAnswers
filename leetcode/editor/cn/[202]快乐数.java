import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//Math.pow(1,2) + Math.pow(9,2) = 82
//Math.pow(8,2) + Math.pow(2,2)= 68
//Math.pow(6,2)+ Math.pow(8,2) = 100
//Math.pow(1,2) + Math.pow(0,2)+ Math.pow(0,2) = 1
// 
// Related Topics 哈希表 数学

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 返回当前数的下一个数
     * @param n
     * @return
     */
    public int getNext(int n){
        int s=0;
        while (n > 0) {
            int d=n%10;
            n=n/10;
            s+=d*d;
        }
        return s;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

