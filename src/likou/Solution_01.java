package likou;

import likou.common_class.ListNode;

/**
 * @Author: Li Guangwei
 * @Descriptions: TODO 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Date: 2022/1/15 16:30
 * @Version: 1.0
 */
public class Solution_01 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head2 = head;
        ListNode head3 = head;
        for(int i = 0 ; i < n; i ++){
            head = head.next;
        }
        //处理倒数第n个节点是第一个节点的问题
        if(head == null){
            return head3.next;
        }

        while (head.next != null){
            head = head.next;
            head2 = head2.next;
        }

        //删除链表
        head2.next = head2.next.next;

        return head3;
    }

}


