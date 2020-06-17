/**
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1:
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串

*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 算法一：
     * 分析：当前一个数比后一个数小时，相当于前一个数取负值加后一个较大的数如   CM=-100+1000=900  那么判断时就与下一个数比较进行相加
     * 对于不同的数  用 switch case先将 I  V  X  L  C  D  M  对应起来  将s字符串拆分进行加法计算

    private int getSingleValue(char n){
        switch (n){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
    public int romanToInt(String s) {
        int sum=0;
        int preNum=getSingleValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int nextNum=getSingleValue(s.charAt(i));
            if (preNum<nextNum&&(nextNum/preNum==5||nextNum/preNum==10)){
                sum-=preNum;
            }else {
                sum+=preNum;
            }
            preNum=nextNum;
        }
        sum+=preNum;
        return sum;
    }*/
    /**
     * 算法二:
     * 将所有的情况都存入Map键值对中，然后将字符串拆分比较逐次相加
     */
    public int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XC",40);
        map.put("XL",90);
        map.put("CD",400);
        map.put("CM",900);
         int sum = 0;
        for(int i = 0;i < s.length();) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

