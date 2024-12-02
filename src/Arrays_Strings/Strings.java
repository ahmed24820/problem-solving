package Arrays_Strings;

import java.util.*;

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
      * [3,30,34,5,9] it will be 9,534,330. we will convert every number into a string and concat them together
      * and use a custom sort to get the best solution with o(n log n) complexity
      * */
     public String largestNumber(int[] nums) {
      String [] arr = new String[nums.length];
       for (int i =0 ; i < arr.length ; i++){
          arr[i] =String.valueOf(nums[i]);
       }
         Arrays.sort(arr,Comparator.reverseOrder());
       StringBuilder stringBuilder = new StringBuilder();

       for (String x : arr){
          stringBuilder.append(x);
       }

      return stringBuilder.toString();
      }

      

        // leetcode 2938
        /*
        * if we have 010100 and want this to be 000011 so we will initilze a ptr in left and right in the first char
        * then we will check if it is 0 we will take the diff it already 0 then move the counter forward then if
        * it is one we will continue without any addition on left until we will found a zero we will take the diff
        * between this zero and one that we iterate last and add it to answer
        * */
        public long minimumSteps(String s) {
        int n = s.length(), left = 0  ; long counter = 0;
         for (int right = 0 ; right < n ; right++){
            if (s.charAt(right) == '0'){
               counter += right - left;
               left++;
            }
         }
         return counter;
        }
        
        
        
        
    
    
    
}
