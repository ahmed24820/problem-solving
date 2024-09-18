import Arrays_Strings.Strings;
import Hashing.HS;
import Math.counter1;

import java.util.List;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Main.class");
        int [] arr = {1,4,8,9,10,20};
        int [] arr2= {3, 7 , 12 , 28 ,80};
        String []Str ={"flower","flow","flight"};
//        Insertion_Sort insertion_sort = new Insertion_Sort();
//        insertion_sort.InsertionSort(arr);
//        SelectionSort sort = new SelectionSort();
////        sort.Selection_Sort(arr);
//        MergeSort MG = new MergeSort();
//        MG.mergeSort(arr , arr2 , arr.length ,arr2.length);
//
//        counter1 counter = new counter1();
//       log.info(counter.findMinDifference(List.of("12:12","00:13")) + "");

        HS hashing = new HS();
        hashing.uncommonFromSentences("this apple is sweet","this apple is sour");

        Strings strings = new Strings();
        strings.reverseSorting();



    }
}