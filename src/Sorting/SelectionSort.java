package Sorting;

public class SelectionSort {
    /*
    *  This sort works with splitting the array to two arrays sorted and unsorted
    *  unless the insertion sort the unsorted array is empty, then we check for the min
    *  number in the array and put it in the unsorted array until it be already sorted
    * */

    public void Selection_Sort(int [] arr){
        int n = arr.length;
       for (int i = 0 ; i < n - 1 ; i++){
         int min = i;
         for (int j = i + 1 ; j < n ; j++){
            if(arr[j] < arr[min]){
              min = j ;
            }
         }
           int temp = arr[i];
           arr[i] = arr[min];
           arr[min] =temp;

           for (int x :arr ){
               System.out.print(x + " \t");
           }
           System.out.println();
       }
    }
    public void swap(int x , int y) {
       int temp = x;
       x = y;
       y =temp;
    }
}
