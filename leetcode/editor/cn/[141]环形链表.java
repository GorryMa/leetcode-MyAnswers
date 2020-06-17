/**
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /**
         * 方法一：  快慢指针  如果存在环   则两个指针一定会相遇   否则   则不存在环   O（1）常量

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if (fast.equals(slow) ) {
                return true;
            }
        }
        return false;
         */
        /**
         * 方法二：使用一个HashSet来判断该节点是否已经存入表中  若存入，代表有换   直至链表为空

        Set<ListNode> set=new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
         */

    }
}
//leetcode submit region end(Prohibit modification and deletion)

