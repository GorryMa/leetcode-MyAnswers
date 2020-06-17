/**
//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 30 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** public boolean isPalindrome(ListNode head) {

         * 方法一：回文链表反转后也是自身，构建一个反转字符串的方法   然后比较反转后的两个链表是否相等   不对

        if (head == null || head.next == null) {
            return true;
        }
        ListNode node = reverseListNode(head);
        while (node !=null) {
            if (node.val!=head.val) {
                return false;
            }
            node=node.next;
            head=head.next;
        }
        return true;
    }
 }
    public ListNode reverseListNode(ListNode root){
        ListNode cur=root;
        ListNode pre=null;
        while (cur != null) {
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
         */
        /**
         * 方法二：
         */
        public boolean isPalindrome(ListNode head) {
            if(head == null) return true;

            ListNode midNode = findMidNode(head);
            ListNode secondHalfHead = reverseLinked(midNode.next);
            ListNode curr1 = head;
            ListNode curr2 = secondHalfHead;

            //boolean palindrome = true;
            while(curr2 != null){
                if(curr1.val != curr2.val) return false;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            return true;
        }

    /* 反转链表 */
    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    /* 快慢指针寻找中间节点 */
    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

