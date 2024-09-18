package Sorting;

public class Bubble_Sort  { // it has also known as sinking sort

    /* this sort work that we put the large numbers in the last of the array
     * then we check every two elements and if the biggest is before we swap them
     * to get the sorted array Big O is (n * 2)
     */


        // this code is mine, and it is slower than the code in below,
       // so we will use the below as it is perfect

       public void BubbleSort(int[]arr){
       int n = arr.length;
        while (n >= 1){
           for(int i =0 ; i < n; i++){
            int j = i+1;
            if(j < n){
            if(arr[i] > arr[j]){
           int demo = arr[i];
             arr[i] = arr[j];
             arr[j] = demo;
           }
            }
        }
          for (int i :arr){
              System.out.print( i + " \t");
          }
            System.out.println();
            n--;
          }
      }

      public void bubble(int[] arr){
        int n = arr.length;
        for (int i = 0 ; i < n - 1 ; i++){
         boolean IsSwapped = false;
         for (int j = 0 ; j < n- 1 -i ;j++){
          if(arr[j] > arr [j+1]){
            int demo = arr [j];
            arr[j]= arr[j+1];
            arr[j+1]=demo;
            IsSwapped =true;
          }
         }
         for (int x :arr ){
             System.out.print(x + " \t");
         }
            System.out.println();
         if(!IsSwapped)break;
        }
      }

    }




