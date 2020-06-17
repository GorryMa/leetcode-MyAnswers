/**
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 42 👎 0

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
    public int kthToLast(ListNode head, int k) {
        /**
         * 方法一：从头遍历一遍记录链表长度n  则倒数k  即为n-k+1

        int len=0;
        ListNode list=head;
        while (list!=null){
            len++;
            list=list.next;
        }
        int index = 1;
        while(head != null){
            if(index == (len - k + 1)){
                return head.val;
            }else{
                index++;
                head = head.next;
            }
        }
        return -1;
         */
        /**
         * 方法二：快慢指针   快指针比慢指针多走k步
         * 则当快指针==null时，慢指针所在处即为所求处
         */
        ListNode slow=head;
        ListNode fast=head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        while (fast != null) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

