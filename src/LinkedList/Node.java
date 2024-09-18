package LinkedList;

public class Node {
    int data;
    Node next, random , prev;

    public Node() {}

    public Node(int data) {
        this.data=data;
        this.next = null;
        this.random=null;
        this.prev= null;
    }

}
