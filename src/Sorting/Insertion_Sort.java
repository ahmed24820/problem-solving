package Sorting;

public class Insertion_Sort {
    /*
    * This is an algorithm is to sort unsorted array by divide it
    * for two arrays (sorted and unsorted) we put the first item in an array
    * in the sorted then we loop from the next then we check the element and
    * put it in the right position in the sorted array to get the sorted array
    *  [9,8,6,7,1,2,3]
    * */
    public void InsertionSort(int [] arr){
        int n = arr.length;
        for (int i = 1 ; i < n ; i++){
           int temp = arr[i];
           int j = i - 1; // this will help us to loop in the sorted array
           while (j >= 0 && arr[j] > temp){
              arr[j+1] = arr[j];
              j = j - 1;  // this is for loop all the elements before
           }
           arr[j+1] = temp;

        }
    }
}
