/**
//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 示例 1: 给定二叉树 [3,9,20,null,null,15,7]
                3
              / \
             9  20
               /  \
             15   7
    返回 true 。
 示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]
                1
               / \
              2   2
             / \
           3   3
         / \
        4   4
 返回 false 。 Related Topics 树 深度优先搜索
// 👍 30 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        /**
         * 深度优先遍历
         */

    }

    /**
     * 利用深度优先遍历求二叉树的高度
     * @param root
     * @return
     */
    public int getHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

