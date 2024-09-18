package Sorting;

public class MergeSort {
    // this sort is to sort two sorted arrays
    public int [] mergeSort(int [] arr1, int [] arr2 , int n , int m){
       int [] finalizer = new int[n+m];
       int i =0 , j = 0 , k = 0;
       while (i < n && j < m){
          if(arr1[i] < arr2[j]){
            finalizer[k] = arr1[i];
            i++;
          }else {
            finalizer[k] = arr2[j];
            j++;
          }
           k++;
       }
       while (i < n){ // this block for if the arr2 is exhausted so, we will fill the elements in arr1
         finalizer[k]=arr1[i];
          i++;
          k++;
       }
        while (j < m){ // this block for if the arr is exhausted so, we will fill the elements in arr2
            finalizer[k]=arr2[j];
            j++;
            k++;
        }
        for(int f :finalizer){
            System.out.print(f +" ");
        }


         return finalizer;
    }
}
