/**
//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。 
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金： 
//
// 
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。 
// 矿工每次可以从当前位置向上下左右四个方向走。 
// 每个单元格只能被开采（进入）一次。 
// 不得开采（进入）黄金数目为 0 的单元格。 
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。 
// 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
// 
//
// 示例 2： 
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 15 
// 0 <= grid[i][j] <= 100 
// 最多 25 个单元格中有黄金。 
// 
// Related Topics 回溯算法 
// 👍 52 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaximumGold(int[][] grid) {
        /**
         * 方法一：考虑使用回溯算法
         */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans=0;
        //对数组的所有点都进行这个遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans=Math.max(ans,dfs(grid,i,j));
            }
        }
        return ans;
    }
    public int dfs(int[] grid,int i,int j){
        //终止条件    超出边界或者遇到该处为0的点
        if (i<0||i=>grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        //先将该点值存储起来
        int temp=grid[i][j];
        //此时将该点的值置为0，防止下次访问
        grid[i][j]=0;
        //向上的最大值
        int up=dfs(grid,i-1,j);
        //向下的最大值
        int down=dfs(grid,i+1,j);
        //向左的最大值
        int left=dfs(grid,i,j-1);
        //向右的最大值
        int right=dfs(grid,i,j+1);
        int max=Math.max(up,Math.max(down,Math.max(left,right)));
        //将该点值复原
        grid[i][j]=temp;
        return temp+max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

