/**
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 55 👎 0

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
    public int[] reversePrint(ListNode head) {
        /**
         * 方法一：先翻转链表，然后逐次打印
         */
        ListNode listNode=null;
        int count=0;
        while (head != null) {
            ListNode temp=head.next;
            head.next=listNode;
            listNode=head;
            head=temp;
            count++;
        }
        int[] ans=new int[count];
        for (int i = 0; i <count ; i++) {
            ans[i]=listNode.val;
            listNode=listNode.next;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

