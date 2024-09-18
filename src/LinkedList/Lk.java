package LinkedList;

import java.util.HashMap;
import java.util.logging.Logger;

public class Lk {
    Logger log = Logger.getLogger(String.valueOf(Lk.class));

  private Node head = null;

  public void insert(int data){
     Node NewNode = new Node(data);
     NewNode=head.next;
     head=NewNode;
   }
   /* this solution to solve the problem of reversing the linked list and return the first value in it,
   *  we will use the middle, previous and next approach to solve it
   *  */
   public Node Reverse(Node head){
     Node demo = head , previous = null , next = null ;
     while (demo != null){
       next = demo.next;
       demo.next = previous;
       previous = demo;
       demo = next;
     }
     return previous;
   }
    /*
    * this solution to solve the merge problem in a linked list we have two sorted lists
    * we will check for null in the start if we have willed merge the one that does not have a null in
    *  answer, else we will compare every element in the two listed and make the solution
    * */
    public Node MergeLists(Node List1 , Node List2){
       Node Answer = new Node(0)
           , tail = Answer ;
       while (true){
       if(List1 == null){
         tail.next = List2;
         break;
        }
        if(List2 == null){
            tail.next = List1;
            break;
        }
            if (List1.data <= List2.data ){
           tail.next = List1;
           List1=List1.next;
        }else {
           tail.next=List2;
           List2=List2.next;
        }
        tail=tail.next;
           }
        return Answer;
    }
     /*
     * this solution is for a problem to get the list with order one from front and one from last,
     * so we will loop to get the middle point then we reverse the list after a middle and get one from front
     * and one from last, so we will get the answer we want
     * */
    public void reorderList(Node head) {
     Node slow = head , fast = slow.next;
     while (fast !=null || fast.next != null){
         slow=slow.next;
         fast=fast.next.next;
     }
     Node first = head;
     Node middle = slow.next;
     slow.next = null ;

     middle = Reverse(middle);

     head = new Node();
     Node currnet = head;
     while (first != null && middle !=null){
       if(first != null){
         currnet.next=first;
         currnet=currnet.next;
         first=first.next;
       }
       if(middle != null){
          currnet.next=middle;
          currnet=currnet.next;
          middle=middle.next;
       }
     }
        head = head.next;
    }
     /*
     * this solution to solve the problem to delete a node with number n from the end we will calc the length of the
     * all list and subtract length and n to get the number of the node from the beginning then we make the pointer of it
     * point to the next.next to remove it from the list
     * */
     public Node removeNthFromEnd(Node head, int n) {
       int length = CalcLength(head) , The_Point_From_Begin = length - n + 1;// we add one for the for loop
       Node current = head , prev = new Node();

        if(length == n){
          head = head.next;  // that means that he wants to delete the first element in the list
          return head;
        }
       for(int i = 1 ; i < The_Point_From_Begin ; i++ ){
         prev =current;
         current =current.next;
       }

        prev.next = current.next;
        return head;

       }
     private int CalcLength(Node head){
        int length=0;
        while (head != null){
          length++;
          head = head.next;
        }
        return length;
     }
     /*
     * this solution to solve the random pointer problem we have a linked list we want to make every node point
     * to the next one and every point has a random pointer we want to make every random pointer point to the place
     * we want  >> we will use the hashMap function with node and node pars to solve this problem
     * */
     public Node copyrandomlist(Node head){
         Node temp = new Node();temp=head;
         HashMap<Node,Node> map = new HashMap<>();
          while (temp != null){
            map.put(temp,new Node(temp.data));
            temp=temp.next;
          }
         temp = head;
          while (temp != null){
            map.get(temp).next = map.get(temp.next); // we now want to customize the second parameter in the hashmap as we want
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
          }
         return map.get(head);
     }
     /*
     * this solution to solve the problem of sum the two nodes with only one digit in the node, so we will use
     * will loop for every integer and add to other with a carry integer to help
     * */
     public Node addTwoNumbers(Node l1 ,Node l2) {
         Node start =new Node() , temp = start ;
         int carry =0;
         while (l1 !=null || l2 != null || carry!=0){
             int  num1 = (l1 == null)?  0 : l1.data
                     ,   num2 = (l2 == null)? 0 : l2.data;
             int sum= num1 + num2 + carry;
             int digit = sum % 10;
             carry = sum /10;
             Node dummy = new Node(digit);
             temp.next = dummy;
             l1 =(l1  == null)? null : l1.next;
             l2 =(l2  == null)? null : l2.next;
             temp = temp.next;
         }
         return start.next;
     }
     /*
     * this problem is to check if the list has a loop in it, we will use the fast and slow pointers to check and return value
     * */
     public boolean hasCycle(Node head) {
         Node slow = head, fast = head;
         boolean HasLoop = false;
         while (fast != null && fast.next != null && slow != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (fast == slow) {
                 HasLoop = true;
                 break;
             }

         }
         return HasLoop;
     }

}
