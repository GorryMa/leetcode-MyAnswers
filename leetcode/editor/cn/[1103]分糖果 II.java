/**
//排排坐，分糖果。 
//
// 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。 
//
// 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。 
//
// 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。 
//
// 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发
//出的糖果多），这些糖果也会全部发给当前的小朋友。 
//
// 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
// 
//
// 
//
// 示例 1： 
//
// 输入：candies = 7, num_people = 4
//输出：[1,2,3,1]
//解释：
//第一次，ans[0] += 1，数组变为 [1,0,0,0]。
//第二次，ans[1] += 2，数组变为 [1,2,0,0]。
//第三次，ans[2] += 3，数组变为 [1,2,3,0]。
//第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
// 
//
// 示例 2： 
//
// 输入：candies = 17, num_people = 3
//输出：[5,2,3]
//解释：
//第一次，ans[0] += 1，数组变为 [1,0,0]。
//第二次，ans[1] += 2，数组变为 [1,2,0]。
//第三次，ans[2] += 3，数组变为 [1,2,3]。
//第四次，ans[0] += 4，最终数组变为 [5,7,5]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candies <= 10^9 
// 1 <= num_people <= 1000 
// 
// Related Topics 数学

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：
     * 设置一个足够大的数组用来模拟人数足够多的糖果分发情况  一直依次加1的分  最后多余的部分往前补即可

     public int[] distributeCandies(int candies, int num_people) {
     int[] ans=new int[num_people];
     for (int i = 0; i < num_people; i++) {
     ans[i]=0;
     }
     if (candies == 0) {
     return ans;
     }
     int s1=0; int other=candies;
     int i=0; int left=1;
     while (other>0) {
     if (i < num_people) {
     ans[i] = ans[i]+Math.min(left,other);
     s1=getSum(left);
     other=candies-s1;
     i++;
     left++;
     continue;
     }
     if (i>=num_people){
     i=0;
     ans[i] = ans[i]+Math.min(left,other);
     s1=getSum(left);
     other=candies-s1;
     i++;
     left++;
     continue;
     }
     }
     return ans;
     }
     */
    /**
     * 方法二：优化
     * @param candies
     * @param num_people
     * @return
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            ans[i] = 0;
        }
        if (candies == 0) {
            return ans;
        }
        //定义一个指针表示每次发给小朋友的最多的糖果数
        int left = 1;
        int other = candies;
        for (int i = 0; i <= num_people; i++) {
            if (other <= 0) {
                break;
            }
            if (i == num_people) {
                i = 0;
            }
            ans[i] = ans[i]+Math.min(left, other);
            other = candies - getSum(left);
            left=left+1;
        }
        return ans;
    }
     */
    /**
     * 不使用前n项和减少时间复杂度
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        if (candies == 0) {
            return ans;
        }
        //定义一个指针表示每次发给小朋友的最多的糖果数
        int left = 1;
        int other = candies;
        for (int i = 0; i <= num_people; i++) {
            if (other <= 0) {
                break;
            }
            if (i == num_people) {
                i = 0;
            }
            ans[i] = ans[i]+Math.min(left, other);
            other = other - left;
            left=left+1;
        }
        return ans;
    }

    /**
     * 求从1开始的前n项和
     * @param x
     * @return
     */
    public int getSum(int x){
        int s=0;
        for (int i = 1; i <=x ; i++) {
            s+=i;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

