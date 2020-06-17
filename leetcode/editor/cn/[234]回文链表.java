/**
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    /**
     * 方法一：将所有listnode的链表值存入list中  若为回文链表  下标相加为list.size（）-1的两个list对象值相等
     * @param head
     * @return

    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head=head.next;
        }
        int left=0;int right=list.size()-1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
     */
    /**
     * 方法二：找到链表的后半部分  反转链表然后双指针两头遍历
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        // 2、反转后半边的链表
        fast = reverse(slow);   // 用 fast 暂存后半链表，方便比较后还原

        // 3、比较两个链表，判断是相同
        ListNode preNode  = head;   // preNode  指向 前半链表表头
        ListNode lastNode = fast;   // lastNode 指向 后半链表表头
        boolean flag = true;        // 判断标志

        while (preNode != lastNode) {
            // 值不相等，修改flag, 退出循环
            if (preNode.val != lastNode.val) {
                flag = false;
                break;
            }
            // 检查完毕
            if (preNode.next == lastNode) {
                break;
            }
            preNode  = preNode.next;
            lastNode = lastNode.next;
        }
        // 4、还原链表
        reverse(fast);
        return flag;
    }

    /**
     * 反转链表
     * @param listNode
     * @return
     */
    public ListNode reverse(ListNode listNode){
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode pre=null;
        ListNode curr=listNode;
        while (curr != null) {
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

