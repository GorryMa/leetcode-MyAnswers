/**
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 50 👎 0

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
         * 方法一：构造一个函数求二叉树的高度  则
         * 平衡二叉树的条件为左右子树均为平衡二叉树且左右子树的高度小于等于1
         */
        if (root == null) {
            return true;
        }
        if ((Math.abs(height(root.left) - height(root.right)) <= 1)&&(isBalanced(root.left)&&isBalanced(root.right))) {
            return true;
        }
        return false;

    }
    public int height(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        }
        return Math.max(height(treeNode.left),height(treeNode.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

