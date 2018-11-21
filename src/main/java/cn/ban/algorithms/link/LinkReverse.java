package cn.ban.algorithms.link;

/**
 * 链表反转
 *
 * @author banzijian
 * @date 2018/10/31
 **/
public class LinkReverse {
    // 非递归
    public static LinkNode notRecursionReverse(LinkNode head){
        LinkNode next = null;
        LinkNode pre = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    // 递归
    public static LinkNode recursionReverse(LinkNode head){
        if (head.getNext() == null) {
            return head;
        }
        LinkNode revHead = recursionReverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revHead;
    }

    public static void main(String[] args) {
        LinkNode oriHead1 = LinkUtil.generateRandomLink(10, 1, 100);
        LinkNode oriHead2 = LinkUtil.copyLink(oriHead1);
        LinkUtil.printLink(oriHead1, "ori");
        LinkNode notRecRevHead = notRecursionReverse(oriHead1);
        LinkUtil.printLink(notRecRevHead, "not rec rev");
        LinkNode recRevHead = recursionReverse(oriHead2);
        LinkUtil.printLink(recRevHead, "rec rev");
    }
}
