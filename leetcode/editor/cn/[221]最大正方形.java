/**
//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 方法一：暴力法
         * 双层循环遍历，如何matrix[i][j]==1，判断正方形可能的最大边长maxLength，则面积为边长的平方maxSide

        int maxSide=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return maxSide;
        }
        int rows=matrix.length;
        int cloumns=matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cloumns; j++) {
                if (matrix[i][j]=='1'){
                    //遇到一个1作为正方形的左上角
                    maxSide=Math.max(maxSide,1);
                    //计算可能的正方形的最大边长
                    int length=Math.min(rows-i,cloumns-j);
                    for (int k = 1; k <length ; k++) {
                        boolean flag=true;
                        //判断正方形右下角是否为1确定最大边长
                        if (matrix[i+k][j+k]=='0'){
                            break;
                        }
                        for (int l = 0; l < k;l++) {
                            if (matrix[i+k][j+l]=='0'||matrix[i+l][j+k]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if (flag){
                            maxSide=Math.max(maxSide,k+1);
                        }
                    }
                }
            }
        }
        return maxSide*maxSide;
         */
        /**
         * 方法二：动态规划
         * 要求最大正方形的面积，先求最大正方形的边长，最大长度为二维矩阵的行长度
         * 若某点坐标值为1，则以此点作为最大正方形的右下角顶点，则此时正方形最大边长为该点左方，上方，左上方三处为正方形右下角顶点作为正方形算出的三个正方形边长的最小值+1
         */
        int maxSide=0;
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return maxSide;
        }
        int rows=matrix.length;
        int cloumns=matrix[0].length;
        //用这个二维矩阵存最大正方形的边长右下角的坐标,该坐标的值表示正方形最大边长
        int[][] dp=new int[rows][cloumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cloumns; j++) {
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    maxSide=Math.max(maxSide,dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

