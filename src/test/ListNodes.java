package test;


import java.util.List;

/**
 * @description 链表常见操作
 * @author: liguangwei
 * @create: 2021-01-01 13:01
 **/
public class ListNodes {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }


    }

    public static void main(String[] args) {

        ListNodes reserveListNode = new ListNodes();
        ListNode listnode11 = new ListNode(1);
        ListNode listnode12 = new ListNode(4);
        ListNode listnode13 = new ListNode(5);
        ListNode listnode14 = new ListNode(6);
        listnode11.next = listnode12;
        listnode12.next = listnode13;
        listnode13.next = listnode14;
        System.out.println(reserveListNode.reserve(listnode11).next.val);

        ListNode listnode21 = new ListNode(2);
        ListNode listnode22 = new ListNode(5);
        ListNode listnode23 = new ListNode(7);
        listnode21.next = listnode22;
        listnode22.next = listnode23;


        System.out.println(reserveListNode.findx(listnode11,1).val);
    }


    /*
    链表反转
     */
    public ListNode reserve(ListNode head) {
       ListNode ssum = new ListNode(-1);
        while (head != null) {

            ListNode nexxt = head.next;
            head.next = ssum.next;
            ssum.next = head;
            head = nexxt;
        }
        return ssum.next;
    }




    /*
    链表环检测
     */
    public boolean  iscir(ListNode head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        if(head.next.next == null){
            return false;
        }
        ListNode sHead = head.next; //慢
        ListNode qHead = head.next.next; //快
        while (sHead != null && qHead != null){
            if(sHead == qHead){
                return true;
            }
            sHead = sHead.next;
            qHead = sHead.next.next;
        }

        return false;
    }

    /*
    两个从小到大的有序链表合并
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        //错就错在每种条件只能执行其中一次
//        if(l1 == null){
//          return l2;
//        }
//        if(l2== null){
//            return l1;
//        }
//        if(l1.val <= l2.val){
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }else{
//            l2.next = mergeTwoLists(l1.next,l2);
//            return l2;
//        }

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    /*
    找出连表倒数第n个耐心（先找用yige 指针移动到第n个位置，然后两个指针同时移送，第二个指针为空，那么第一个指针就是）
     */
    public ListNode findx(ListNode head, int n){
       ListNode p1 = head;
       ListNode p2 = head;
       int i = 1;
       while ( i < n && p2.next != null ){
           p2 = p2.next;
           i ++;
       }
       if(i < n && p2.next == null){
           return new ListNode(-1);
       }

       while( p2.next != null){
           p1 = p1.next;
           p2 = p2.next;
       }
       return p1;
    }

    /*
    链表中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
