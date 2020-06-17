/**
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 65 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        /**
         * 方法一：使用临时缓冲区  Set去重

        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;         */
        /**
         * 方法二：双循环
         */
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (temp.next != null) {
                if (temp.next.val == cur.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

