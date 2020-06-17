/**
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3

 如下例子为不对称的
           1
          / \
         2   2
       / \ / \
      3  4 4  3
     / \ / \/ \ / \
    3 5 5 3 3 4 4 3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
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
     * 方法一：递归
     * 入口为二叉树只有一个根节点   一定是对称二叉树
     * 若一个树为对称二叉树，其左子树与右子树相互对称

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return twoTreesIsymmetric(root.left,root.right);
    }
    /**
     * 判断两个二叉树是否是对称的

    public boolean twoTreesIsymmetric(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val!=t2.val){
            return false;
        }else {
            return twoTreesIsymmetric(t1.left,t2.right)&&twoTreesIsymmetric(t1.right,t2.left);
        }
    }
    */
    /**
     * 方法二：迭代
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return twoTreesIsymmetric(root.left,root.right);
    }

    public boolean twoTreesIsymmetric(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                return true;
            }
            if (u == null || v == null){
                return false;
            }
            if (u.val != v.val) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

