package Stack_Queues.Stack_Queues;

public class CustomStack {
    int[] arr;
    int top;
    int length;
    public CustomStack(int maxSize){
     arr = new int [maxSize];
     length = 0 ;
     top = -1 ;
    }
    public void push(int x){
        if (isFull()){
         return;
        }
        arr[++top] = x;
        length++;
    }
    public int pop(){
        if (isEmpty()){
            return -1;
        }
        length--;
        return arr[top--];
    }
	public void increment(int k , int val){
		for (int i = 0 ; i < Math.min( k , top + 1) ; i++){
         arr[i] += val;
      }
    }
    public boolean isEmpty(){
       return length == 0 ;
    }
    public boolean isFull(){
       return length == arr.length ;
    }

    }



