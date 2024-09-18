package Math;
import Arrays_Strings.Strings;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
public class counter1 {
    /*
     *  this problem is for that if we want to add an integer to other we don't always need to use string then convert we
     * can use long and * 10 and sum them
     * */
    Logger log = Logger.getLogger(String.valueOf(counter1.class));

    public counter1() {
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


      }




