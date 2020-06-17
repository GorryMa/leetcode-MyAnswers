/**
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
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
    public ListNode detectCycle(ListNode head) {
        /**
         * 方法一：将所有访问过的节点存入HashSet中并将链表持续向前移动，如果访问到了HashSet中存在的节点，则该节点就为入口节点

        Set<ListNode> set=new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
         */
        /**
         * 方法二：采取快慢指针的方式，快指针一次走两步   慢指针一次走一步
         * 则当两个指针相遇时，一定是在环形链表内部且快指针走的总长度为慢指针的两倍
         * 假设链表外部非循环链表部分长度为s,循环链表内慢指针走过的路程为x，则
         * 慢指针总路程为s+x
         * 快指针总路程为2*（s+x），在循环链表内走过的路程为s+2*x
         * 设循环链表的长度为l      则有s+2*x-x=s+x=n*l  即s=nl-x；
         * 即s=nl-x；  该式意味着慢指针在循环链表在从相遇点开始经过nl-x的长度会回到节点处
         * 则我们重新指定一个指针从头开始移动  两者恰好在节点处相遇
         */
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        fast=head;
        while (fast!=slow) {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

