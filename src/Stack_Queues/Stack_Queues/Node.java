package Stack_Queues.Stack_Queues;

public class Node {

    public int data;
    public Node next;
    public int minData;

    public Node(){

    }
    public Node(int data ){
       this.data=data ;
    }
    public Node(int data ,int MinData ,Node next){
        this.data = data;
        this.minData = MinData;
        this.next = next;
    }
}
