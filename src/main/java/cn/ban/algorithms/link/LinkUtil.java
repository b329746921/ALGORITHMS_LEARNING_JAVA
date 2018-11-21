package cn.ban.algorithms.link;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author banzijian
 * @date 2018/10/31
 **/
public class LinkUtil {
    public static LinkNode generateRandomLink(int length, int left, int right) {
        if (length < 1) {
            System.out.println("link长度不能小于1");
        }
        LinkNode head = new LinkNode(RandomUtils.nextInt(left, right));
        LinkNode poi = head;
        for (int i = 1; i < length; i++) {
            int randomInt = RandomUtils.nextInt(left, right);
            poi.setNext(new LinkNode(randomInt));
            poi = poi.getNext();
        }
        return head;
    }

    public static LinkNode copyLink(LinkNode head){
        if (head == null) {
            return null;
        }
        LinkNode newHead = new LinkNode(head.getValue());
        LinkNode poi = newHead;
        while (head.getNext() != null) {
            poi.setNext(new LinkNode(head.getNext().getValue()));
            head = head.getNext();
            poi = poi.getNext();
        }
        return newHead;
    }

    public static void printLink(LinkNode head, String title) {
        String result = "";
        while (head != null) {
            result = result + (head.getValue() + " -> ");
            head = head.getNext();
        }
        if (title.length() < 12) {
            for (int i = title.length(); i < 12; i++) {
                title += " ";
            }
        }
        System.out.println(title + " [ " + result.substring(0, StringUtils.isBlank(result) ? 0 : result.length() - 4) + " ]");
    }
}
