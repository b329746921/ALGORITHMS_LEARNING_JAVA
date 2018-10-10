package cn.ban.algorithms.sort;

/**
 * @author banzijian
 * @date 2018/10/02
 **/
public class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
