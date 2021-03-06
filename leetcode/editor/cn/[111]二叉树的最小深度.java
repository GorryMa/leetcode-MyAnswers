/**
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

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
    /**
     * 方法一：动态规划
     * 如果一个二叉树为空，则最小深度为0，
     * 如果左右子树同时为null，则二叉树深度为1，
     * 如果左右子树有一个为空，则二叉树深度为1+非空子树的深度
     * 否则最小深度为1+左右子树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1+minDepth(root.right);
        }
        if (root.right == null) {
            return 1+minDepth(root.left);
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

