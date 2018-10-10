package cn.ban.algorithms.sort;

import java.util.PriorityQueue;

/**
 * @author banzijian
 * @date 2018/10/02
 **/
public class Test {
    // 1 8 3 6 5 4 7 2 9
    public static void main(String[] args) {
        Node node9 = new Node(9);
        Node node2 = new Node(2, node9);
        Node node7 = new Node(7, node2);
        Node node4 = new Node(4, node7);
        Node node5 = new Node(5, node4);
        Node node6 = new Node(6, node5);
        Node node3 = new Node(3, node6);
        Node node8 = new Node(8, node3);
        Node head = new Node(1, node8);

        Node[] lists = getLists(head);
        for (Node node : lists) {
            printLinked(node);
            System.out.println();
        }
    }

    private static Node[] getLists(Node head){
        Node head1 = null;
        Node head2 = null;

        Node cur1 = null;
        Node cur2 = null;

        int count = 1;
        while (head != null) {
            if ((count & 1) == 1) {
                if (head1 == null) {
                    cur1 = head;
                    head1 = cur1;
                } else {
                    cur1.next = head;
                    cur1 = cur1.next;
                }
            } else {
                if (head2 == null) {
                    cur2 = head;
                    head2 = cur2;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                }
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;
        return new Node[]{head1, head2};
    }

    private static void printLinked(Node head){
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
