package Arrays_Strings;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
       List <int []> Books;
       public MyCalendar(){
         Books= new ArrayList<>();
       }

    public boolean book(int start , int end){
        for (int [] book : Books){
          if (Math.max(book[0],start) < (Math.min(book[1],end))){
              return false;
          }
         }
        Books.add(new int[]{start,end});
        return true;
    }

    }


