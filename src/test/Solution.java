package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @author: liguangwei
 * @create: 2021-04-12 11:36
 **/
public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public ListNode find(ListNode listNode1, ListNode listNode2){
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        while (p1 != p2){
            p1 = p1.next == null ? listNode2 : p1.next;
            p2 = p2.next == null ? listNode1 : p2.next;
        }
        return p1;
    }


    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */

    int[] hashArray = new int[256];
    StringBuffer sb = new StringBuffer();

    public void Insert(char ch)
    {
        sb.append(ch);
        if(hashArray[ch] == 0){
            hashArray[ch] = 1;
        }else{
            hashArray[ch] += 1;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        char[] strs = sb.toString().toCharArray();
        for(char c : strs){
            if(hashArray[c] == 1){
                return c;
            }
        }

        return '#';
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList reserver(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode aa = reserve(listNode);
        while (aa != null){
            list.add(listNode.val);
            aa = aa.next;
        }
        return list;

    }

    public ListNode reserve(ListNode listNode){
        ListNode reservelist = new ListNode(-1);
        ListNode phead = listNode;
        while (phead != null){
            ListNode aa = phead.next;
            phead.next = reservelist.next;
            reservelist.next = phead;
            phead = aa;
        }
        return reservelist.next;
    }


    /**
     *给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
     * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    public int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int a = target % 3;
        int b = target / 3;
        if(a == 0){
            return (int)Math.pow(3,b);
        }else if(a == 1){
            return (int)Math.pow(3,b-1)*2*2;
        }else {
            return (int)Math.pow(3,b)*2;
        }
    }



    //第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
    //第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,
    // p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。

    ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode removeRepeat(ListNode pHead){
        if(pHead==null||pHead.next==null)return pHead;
        ListNode head=new ListNode(0);
        head.next=pHead;
        ListNode fast=head.next,slow=head;
        while(fast!=null&&fast.next!=null){
            if(fast.val==fast.next.val){
                while(fast.next!=null&&fast.val==fast.next.val){
                    fast=fast.next;
                }
                slow.next=fast.next;
                fast=fast.next;
            }else{
                slow=slow.next;
                fast=fast.next;
            }
        }
        return head.next;
    }

    //LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
    // 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
    // “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
    // 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
    // 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

    public boolean IsContinuous(int [] numbers) {

        if(numbers.length != 5){
            return false;
        }
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i -1; j ++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < numbers.length-1; i ++){
            if(numbers[i] != 0 && numbers[i] == numbers[i+1]){
                return false;
            }

            if (numbers[i] == 0) {
                count ++;
            }
        }

            if(numbers[4] - numbers[count] > 4){
                return false;
            }


        return true;
    }


    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
     *其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
     * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
     * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     */


    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3 ; j++){
                System.out.println(i+" "+j);
                break;
            }
        }
    }

}
