package BinarySearchAsks;

public class BS {
    public int BinarySearch(int [] arr , int target){
       final int n=arr.length;
       int start=0 , end =n-1 ;
       while (start < end){
           int mid =( start + end ) /2;
         if(arr[mid] == target){
            return mid;
         }else if (arr[mid] < target){
            start=mid+1;
         }else if (arr[mid]>target){
             end=mid-1;
         }
       }
        return -1;
    }
           /*
           * this solution is for a problem to find the target number in the 2d matrix by using the
           * Binary Search
           * */

         public boolean searchMatrix(int [][]Matrix,int target){
            final int n = Matrix.length , m = Matrix[0].length;
            int left = 0 , right = n * m -1;
            while(left<right){
             int midpoint = (left + right) /2;
            /* to search in two-dimensional matrix, we need two coordinates so
             we will get the mid-row by divide the midpoint by m, and
            we will get the mid-column by modules the midpoint by m
            * */
            int mid_row= midpoint / m;
            int mid_col=midpoint % m;
            if(Matrix[mid_row][mid_col] == target){
                return true;
            }else if (Matrix[mid_row][mid_col] < target){
                left=midpoint+1;
            }else if (Matrix[mid_row][mid_col]>target){
                right=midpoint-1;
            }
             }
         return false;
         }
         /*
         * this problem is to calc the number of bananas per hour that koko can take to finish the piles
         * we want to search in a matrix like this [3,6,7,11] so we want to check every number from 1 to 11
         * we want to make it take less time, so we will use the Binary Search, the left will be 1 and right will
         *  be the max  value in piles
         * */
          public int KoKoPiles(int []piles,int h){
             int left = 1 , Right = 0;
             for (int i : piles){
                 Right =Math.max(Right,i);
                 }
             int res = Right;
                while (left <= Right){
                   int hours = 0;
                    int mid = (left +Right) /2 ;
                   for( int k : piles){
                       hours += ( k / mid);
                       hours += (k % mid != 0) ? 1 : 0;
//                       System.out.println("the hour rate for " + k + " is >>" +  hours);
                   }
                   if( hours <= h){
                       res = Math.min(mid,res);
                       Right = mid -1;
                   }else {
                       left = mid +1;
                   }
                }
             return res ;
          }

          /*
          * this solution is to solve the problem to find the min number in a rotated array with (log n),
          * so we will check if the first element is less than the last that means it is sorted really
          * we also will use the binary search
          * */
           public int RotatedArray(int [] numbs){
             final int n = numbs.length ;
             int minimum = numbs[0];
             if(numbs[0] < numbs[numbs.length-1] ){
                 return minimum;
             } else if(n == 1){
                 return numbs[0];
             }else {
               int  left = 0 ,right = numbs.length - 1;
              while (left <= right){
                int mid = (left + right) /2;
                  minimum = Math.min( numbs[mid] , minimum);
                 if(numbs[mid] < numbs[right]){
                    right = mid -1;
                 } else {
                     left = mid + 1;
                 }
             }
           }
               return minimum;

           }

            public int search(int[] nums, int target) {
               final int n = nums.length ;
               if(target == nums[0]){
                   return 0;
               } else if (target == nums[n-1]) {
                   return n-1;
               }else {
                   int  left = 0 , right = nums.length - 1;
                   while (left <= right){
                       int mid = (left + right) / 2;
                        if(nums[mid] == target){
                          return mid;
                        }
                       else if(nums[mid] > target && target > nums [0]){
                           right = mid -1;
                       } else {
                           left = mid + 1;
                       }
                 }
                }
            return -1;
    }
}


