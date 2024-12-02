package Math.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Counter {
    /*
     *  this problem is for that if we want to add an integer to other we don't always need to use string then convert we
     * can use long and * 10 and sum them
     * */
    Logger log = Logger.getLogger(String.valueOf(Counter.class));

    public Counter() {
    }

    public int ReverseInteger(int num) {
        long FinalNumber = 0;
        boolean isNegative = false;
        if (num == 0) {
            return 0;
        }
        if (num < 0) {
            num *= -1;
            isNegative = true;
        }
        while (num > 0) {
            int finalDigit = (num % 10);
            FinalNumber += finalDigit;
            FinalNumber *= 10;
            num = num / 10;
        }
        FinalNumber = FinalNumber / 10;
        if (isNegative) {
            FinalNumber *= -1;
        }
        if (FinalNumber >= Integer.MAX_VALUE || FinalNumber <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) FinalNumber;
    }
    
    
      public boolean isPalindrome(int x){
           StringBuilder s=new StringBuilder(String.valueOf(x));
           s.reverse();
          System.out.println(s);
          return s.toString().equals(x + "");
      }
  
      public int mySqrt(int x) {
        int left = 1 , right = x , answer = 0;
        if(x == 0 || x == 1){
            return x;
        }
        while(left <= right){
            int mid = (left + right) /2; // we will use the (left + (right - left ) /2 ) instead
            if( mid * mid == (x)){
                answer =mid;
                return answer;
            }
            else if( (long) mid * mid > (long) x){
                right = mid-1;
            }else if(mid * mid < x){
                left =mid +1;
            }
        }
        return Math.round(right);
     }

        // this problem to solve bitwise And operator it is an operator that works with binary of the num
        // and if the two number equal one, it will be one
        public int longestSubarray(int[] nums) {
          final int n = nums.length;
          int bigBitWise = 0 , counter = 0 , answer = 0;
            List<Integer> counters = new ArrayList<>();
          for (int x: nums){
             if(x > bigBitWise){
                 bigBitWise = x;
             }
          }
            for(int i =0 ; i < n ; i++){
                if(i+1 <= n-1 && nums[i] == bigBitWise && nums[i+1] == bigBitWise){
                    counter++;
                }else {
                    counters.add(counter);
                    counter = 0;
                }
            }
            for(int x : counters){
                if(x > answer){
                    answer = x;
                }
            }
            return answer+1;
        }
        /*
        *BITMASK PROBLEM
        * Bitmask is a binary number we do an arithmetic operation with it to the original number to check if it is the first
        * to occur or not.
        * */
        public int findTheLongestSubstring(String s) {
         final int n = s.length();
         int arr [] = new int[32]; // 32 as we will present the number in 5 digit 00000 so max one will be 11,111 represent 32
            Arrays.fill(arr,-3);
             arr[0]=-1;
          int mask = 0 , maxLength = 0;
         for(int i = 0 ; i < n ; i++){
           char c = s.charAt(i);
           switch (c){
                case 'a':
                mask ^= 1;
                    break;

                case 'e':
                   mask ^= 2;
                        break;

               case 'i':
                   mask ^= 4;
                       break;

               case 'o':
                   mask ^= 8;
                     break;

               case 'u':
                   mask ^= 16;
                       break;
           }

           int current = arr[mask]; // we will check if the vowel has been occurred or not
            if(current == -3){
              arr[mask] = i;
            } else {
               maxLength = Math.max(maxLength , i - current);
            }
         }
         return maxLength;
        }

        /*
        * the hour and minutes format problem we want to get the minimum difference between the list of time u will get
        * in the question
        * 1 - we will convert every time to minutes then sort them to make the numbers that are a little bit similar
        * 2 - calc the minimum time then check for the circular iteration for the time as 24:00
        * */

         public int findMinDifference(List<String> timePoints) {
          List<Integer> timeInMinutes = new ArrayList<>();
           int ans = Integer.MAX_VALUE;
          for (String time : timePoints){
              int calc_time = getTimeInMinutes(time);
              timeInMinutes.add(calc_time);
              System.out.println(calc_time);
          }
             Collections.sort(timeInMinutes);
            for (int i = 1 ; i <= timeInMinutes.size()-1; i++){
               int little_difference = timeInMinutes.get(i) - timeInMinutes.get(i-1);
               if(little_difference < ans){
                  ans = little_difference;
               }
            }
            return Math.min(ans , 24*60 - timeInMinutes.get(timeInMinutes.size()-1) + timeInMinutes.get(0));
         }

         public int getTimeInMinutes(String s){
           String [] time = s.split(":");
           int hours = Integer.parseInt(time[0]);
           int minutes = Integer.parseInt(time[1]);
           hours *= 60;
          return hours + minutes;
         }

    public String shortestPalindrome(String s) {
        int count = kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString() + s;

         }

     /*
     * this problem description is that we have a string and pattern and want to make
     * the string is palindrome to the pattern so we will check for the common prefix of the pattern
     * and then get the substring and reverse it then add it to the front of string
     * */

      private int kmp(String txt, String patt) {
        String newString = patt + '#' + txt;
        int[] pi = new int[newString.length()];
        int i = 1, k = 0;
        while (i < newString.length()) {
            if (newString.charAt(i) == newString.charAt(k)) {
                k++;
                pi[i] = k;
                i++;
            } else {
                if (k > 0) {
                    k = pi[k - 1];
                } else {
                    pi[i] = 0;
                    i++;
                }
            }
        }
        for (int x : pi){
            System.out.print(x);
        }
        return pi[newString.length() - 1];
    }

    /*
    *  Description - - > Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
    *  You must write an algorithm that runs in O(n) time and uses O(1) extra space.
    *
    *  we will use an iterative approach we will make a list and loop from one to n then if number < n we will * 10
    * if still < n we will add to list then if number % 10 = 9 we will increase the number then % 10 and add to list
    * and repeat what we do before until the number equal n.
    *  */

    public List<Integer> lexicalOrder(int n) {
     List<Integer>answer= new ArrayList<>();
      int current = 1 ;
     for(int i = 1 ; i <= n ; i++){
       answer.add(current);
       if(current * 10 <= n){
        current *= 10;
       }else {
        while (current % 10 == 9 || current >= n){
            /* this check for us if the number say 19 we will divide to 10, then
            it will be incremented by one then continue the process. */
           current /= 10;

        }
        current ++;
       }
     }
     for (int x : answer){
         System.out.print(x + "\t");
     }
        return answer;
    }

    
    public int findKthNumber(int n, int k){
     int num = 1;
     int i = 1;
     while ( i <= k){
       int steps = count( num ,num+1 , n);
//         System.out.println( "the counter i is " + i + "\t" + "steps that will be added are" + steps + "number is " + num);
       if( i + steps <= k){
          i += steps;
          num ++;
       }else {
           i++;
           num *= 10;
       }

     }
     return num;
    }
    
      private int count (long num , long nei , int n){
       int steps = 0;
       while (num <= n){
        steps += (int) (Math.min(n+1,nei) - num);
        num *= 10;
        nei *= 10;
       }
       return steps;
      }

    // leetcode 670
    public int maximumSwap(int num) {
     char [] digits = String.valueOf(num).toCharArray();
      char max_digit = '0';
      int max_i = -1 , swap_i = -1 ,swap_j = -1;
      
      for (int i = digits.length - 1; i >= 0 ; i--){
         if (digits[i] > max_digit){
             max_digit = digits[i];
             max_i= i;
         }
         if (digits[i] < max_digit){
            swap_i = i ;
            swap_j = max_i;
         }
      }
        if (swap_i == -1){
         return num;
        }
      char temp = digits[swap_i];
      digits[swap_i] = digits[swap_j];
      digits[swap_j] = temp;
      
     
      return Integer.parseInt(new String(digits));
      
      
    }
   
    
}






