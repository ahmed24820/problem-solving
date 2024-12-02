package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Learning {
        /*
    * this example to learn us if we want to print the number in binary 0/1
    * */
       public void printBinary(int num) {
        if (num >= 1) {

            printBinary(num / 2); // that will be 214 / 2 = 107
            System.out.println(num % 2);
        }
    }
   
   
       /* we want to trace the recursion function, so
          we will make a table that shows us the end statement that will return us to
          the base then we go forward
        */
        public  void GenerateThreeNum(int len, String str){
            if(len == 0){
                System.out.println(str);
                return;
            }
            GenerateThreeNum(len-1 ,str+"0");
            GenerateThreeNum(len-1 , str+"1");
        }

        public int factorial(int n){
            if(n < 2){
              return 1;
            }
            return n * factorial(n-1);
        }
        
         public int fibonacci(int n){
            if(n < 2) return n;
            return fibonacci(n-1) + fibonacci(n-2);
         }


          /* this fucking  problem to find every lucky number that only has (4 or 7)
           so we will use recursion to loop for every number * 10 +4 || number * 10 +7 to get (4 / 44 / 444 |7 /77 /777)
           like this sequence then we put every number in a list then we sort it and return the index that the number
           allocated in
          */

          List<Long>Luckiest = new ArrayList<>();
         public void lucky(long n){
            if(n > Integer.MAX_VALUE){
               return ;
            }
            if(n != 0 ){
              Luckiest.add(n);
            }
             lucky(n * 10 + 4);
             lucky(n * 10 + 7);
         }

         
         public long findIndex(long n){
            lucky(0);
             Collections.sort(Luckiest);
             for(int i = 0 ; i <Luckiest.size() ; i++ ){
               if( Luckiest.get(i) == n){
                 return i+1;
               }
             }

             return -1;
         }
         
         
         // leetcode 2044
         public int countMaxOrSubsets(int []nums){
          int maxOr = 0 , count = 0 ;
          for (int x : nums){
             maxOr |= x ;
          }
          backTrack(nums,0,0,maxOr,count);
          return count;
         }
         //[3.2.1.5] --> 7
         private void backTrack(int [] nums , int index , int currentOR , int maxOR , int count){
             if (currentOR == maxOR){
                 count++;
             }
             for (int i = index ; i < nums.length ; i++){
                backTrack(nums , i + 1 , currentOR | nums[i] ,maxOR ,count);
             }
         }
         
         
         public boolean isPowerTwo(int n){
           if (n <= 0)return false;
           if (n == 1) return true;
           return (n % 2 == 0 && isPowerTwo (n/2) );
         }


}

