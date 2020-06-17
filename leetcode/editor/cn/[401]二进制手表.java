import java.util.ArrayList;
import java.util.List;
/**
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法 
// 👍 166 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list=new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        /**
         * 方法一：双循环遍历
         * 小时从0-11  时间从0-59
         * 分别计算小时和分钟中有多少个1
         * 如果小时中的1的个数和分钟中的1的个数的和为num     格式化输出即可

        List<String> list=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    list.add(String.format("%d:%02d",i,j));
                }
            }
        }
        return list;
         */
        /**
         * 回溯算法
         */
        backTrack(num,0,new int[10]);
        return list;

    }
    public void backTrack(int num,int cur,int[] book){
        if (num == 0) {
            int hour=book[0]+2*book[1]+4*book[2]+8*book[3];
            int minute=book[4]+2*book[5]+4*book[6]+8*book[7]+16*book[8]+32*book[9];
            if (hour < 12 && minute < 60) {
                list.add(String.format("%d:%02d",hour,minute));
            }
            return;
        }
        for (int i = cur; i <book.length ; i++) {
            book[i]=1;
            backTrack(num-1,i+1,book);
            book[i]=0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

