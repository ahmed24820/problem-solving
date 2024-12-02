package Math.Math;

import java.util.HashSet;

public class SlidingWindowApproach {

	public int minSubArrayLen(int target, int[] nums) {
	 int start = 0 , minCounter = Integer.MAX_VALUE , windowSum = 0 ;
	 
	  for (int end = 0 ; end < nums.length ; end++){
		 windowSum += nums[end];
		 
		 while (windowSum >= target){
			 // we will calc the length of the subArray to get the solution.
		  minCounter = Math.min (minCounter , end - start + 1 ) ;
		  windowSum -= nums[start ++];
		 }
	  }
	 return minCounter == Integer.MAX_VALUE ? 0 : minCounter;
	}
	
	public int LengthOfLongestSubstring(String s){
	 // we can use the hasSet to solve this problem in Big O(n)
	 int start = 0 , end = 0 ,maxLen = Integer.MIN_VALUE ;
		HashSet<Character> hashSet = new HashSet<> ();
	   // we will add every char and check if it is already in the set if yes will loop in it until we remove it
	    // we need a substring that characters are Consecutive
	   while (end < s.length ()){
		char c = s.charAt (end);
		while (hashSet.contains (c)){
		  hashSet.remove (s.charAt (start));
		  start++;
		}
		hashSet.add (c);
		end++;
		maxLen = Math.max (maxLen , end - start +1 );
	   }
		return maxLen;
	}

	}
