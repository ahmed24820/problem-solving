package Heaps_ProirityQueues;

public class Heap_implementation {
    int [] heap;
	int n ;
	
	public Heap_implementation(int capacity){
	  heap = new int[capacity+1]; // we add 1 here as in heap we do not use the element 0
	  n=0;
	}
    public boolean isEmpty(){
		return n == 0;
    }
	public int size(){
		return n;
	}
	
	public void insert(int x){
	  if (n == heap.length - 1){
		 resize( 2 * heap.length);
	  }
	  n++;
	  heap[n] = x;
	  swim(n);
	}
         /*
         * this method helps us with ordering every element in his correct position
         * */
		private void swim(int i) {
		 while (i > 1 && heap[i] > heap[i/2]){
			int temp = heap[i];
			heap[i] = heap[i/2];
			heap[i/2] = temp;
			i = i/2;
		  }
	    }
		
		private void resize(int capacity) {
	 	 int[] temp = new int[capacity];
			System.arraycopy(heap, 0, temp, 0, heap.length);
		  heap = temp;
	    }
		public void show (){
			for (int i = 1 ; i <= n ; i++){
				System.out.print(heap[i] + " ");
			}
		}
	
	
}
