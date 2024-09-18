package Arrays_Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Strings {
    public String longestPalindrome(String s) {
     int start = 0 , end = 0;
     for (int i = 0 ; i < s.length() ; i++){
       int len1 = expandFromMiddle(s,i,i);
       int len2 = expandFromMiddle(s,i,i+1);
       int max = Math.max(len1,len2);

       start = i - (max - 1) / 2;
       end = i + (max / 2);
     }
       return s.substring(start,end + 1);

    }
    public int expandFromMiddle(String s , int left , int right){
        if (s == null || left > right){
            return 0;
        }
       while (left <= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
           left --  ;
           right ++ ;
       }
       return right - left - 1 ; // the len of the Palindrome that we get from the middle
    }

    /*
    * this problem to get the common prefix for every string that has the same letters in the begin
    * like if we have a (floor,flower, flight) we will return "fl"
    * */

    public String longestcommonPrefix(String [] Strs){
        int smallestLength = Integer.MAX_VALUE;
        for(String str : Strs){
           if(str.length() < smallestLength){
               smallestLength =str.length();
           }
        }
        int index = 0;
        while (index < smallestLength){
            for (String str : Strs){
             if (str.charAt(index) != Strs[0].charAt(index)){
                 return Strs[0].substring(0,index);
          }
        }
            index ++;
        }
        return Strs[0].substring(0,index);
     }

      /*
      * this problem wants us to find the largest number from the numbers in the array
      * [3,30,34,5,9] it will be 9534330. we will convert every number into a string and concat them together
      * and use a custom sort to get the best solution with o(n log n) complexity
      * */
     public String largestNumber(int[] nums) {
      String [] arr = new String[nums.length];
       for (int i =0 ; i < arr.length ; i++){
          arr[i] =String.valueOf(nums[i]);
       }
         Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
       StringBuilder stringBuilder = new StringBuilder();

       for (String x : arr){
          stringBuilder.append(x);
       }

      return stringBuilder.toString();
      }

      public List<String> reverseSorting(){
         List<String> reversed = Arrays.asList("ahmed", "mogihamed", "momen");
         Collections.sort(reversed, Comparator.naturalOrder());

         for (String x : reversed){
             System.out.println(x);
         }
         return reversed;
       }


}
