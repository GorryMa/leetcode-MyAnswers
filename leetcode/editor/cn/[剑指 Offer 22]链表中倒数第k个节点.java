/**
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 81 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //public ListNode getKthFromEnd(ListNode head, int k) {
        /**
         * 方法一：求出链表的长度  然后遍历   超时

         ListNode cur=head;
         int length=0;
         while (cur != null) {
         length++;
         cur=cur.next;
         }
         for (int i = 0; i < length-k; i++) {
         head=head.next;
         }
         return head;
         */
        /**
         * 方法二：双指针
         * 快指针先移动到整数第k个节点，即移动k-1步，此时快慢指针相差k个节点（含头和尾）
         * 则当快指针移动到末尾时，慢指针的位置即为倒数第k个节点

         ListNode slow=head;
         ListNode fast=head;
         for (int i = 0; i < k - 1; i++) {
         fast=fast.next;
         }
         while (fast.next!= null) {
         slow=slow.next;
         fast=fast.next;
         }
         return slow;
         */
        /**
         * 递归  递归求字符串的长度  当长度为k时  则倒数k即为此时头结点
         */
    int size;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode node = getKthFromEnd(head.next, k);
        if (++size == k)
            return head;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

