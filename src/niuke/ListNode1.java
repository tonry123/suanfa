package niuke;

/**
 * @description 删除连标重复节点
 * @author: liguangwei
 * @create: 2020-08-12 17:23
 **/
public class ListNode1 {

    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            i++;
            System.out.println(i);
            int z = 0;
            while(z <2){
                z++;
                System.out.println("pppp");
                break;
            }
            System.out.println("ooooo");

        }


    }

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        ListNode pre = null;
        ListNode last = pHead;
        if (pHead == null) return null;
        while (last != null){
            boolean flag = true;
            if(last.val == last.next.val && last.next != null){
                while(last.val == last.next.val && last.next != null){
                    last = last.next;
                }
                if(last.next != null){
                    last = last.next;
                    pre.next = last;
                }else {
                    pre.next = null;
                }
            }else {
                pre = pre.next;
                last = last.next;
            }

        }

        return pHead;
    }
}
