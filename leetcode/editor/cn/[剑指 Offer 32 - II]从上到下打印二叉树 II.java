/**
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 44 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 方法一：使用广度优先算法，使用双向链表  每次先把根节点放进队列，然后弹出根节点，再把对应的左右节点放在队尾
         * 当本层的根节点弹出完毕，本层的广度优先搜索算法结束  进入下一层   直至队列为空   即二叉树遍历完毕
         */
        List<List<Integer>> list=new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size=q.size();
            List<Integer> list1=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur=q.poll();
                if (cur != null) {
                    list1.add(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

