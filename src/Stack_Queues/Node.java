package Stack_Queues;

public class Node {

    int data;
    Node next;
    int minData;

    public Node(){

    }
    public Node(int data){
       this.data=data;
    }
    public Node(int data ,int MinData ,Node next){
        this.data=data;
        this.minData=MinData;
        this.next=next;
    }
}
