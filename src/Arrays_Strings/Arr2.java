package Arrays_Strings;

public class Arr2 {

    // leetcode 66 plus one
    public int[] plusOne(int [] digits) {
        /*
            we have an array of digits we want to add 1 to them and return the array again
            we will check for the last digit if it equals 9 we will put 0 and then increase the previous digit by one
            but if we have the digits all with 9 now we had a problem like --> (9,9,9,9,9) -- > gonna be (1,0,0,0,0,0)
            so what to do we will increase the array by one and one in the front
        */
      for (int i = digits.length-1 ; i >= 0 ; i--){
         if (digits[i] < 9 ){
           digits[i] ++ ;
           return digits;
         }
         digits[i] = 0;
      }

      digits = new int[digits.length + 1 ];
      digits[0] = 1;
      return digits;

    }


}
