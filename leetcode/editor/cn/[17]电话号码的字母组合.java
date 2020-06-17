import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：先用一个hashmap将所有的数字对应的存放进去
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map=new HashMap<Integer, String>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> list=new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {


        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

