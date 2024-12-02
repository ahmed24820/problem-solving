package Math.Math;
import java.util.HashMap;

public class TwoPointerApproach {

   public boolean isPalindrome(String s){
	 s = s.toLowerCase ();
	 s = s.replaceAll ("[^a-z0-9]","");
  
	 int i = 0 , j = s.length () - 1 ;
    
    while (i <= j){
		if (s.charAt (i) != s.charAt (j)){
			return false;
		}
		i++;j--;
    }
	   System.out.println (s);
	return true;
   }
   
   public boolean isSubsequence( String s , String t){
	   int i = 0 , j = 0 , counter = 0 ;
	   while (i < s.length () && j < t.length ()){
		  if (s.charAt (i) == t.charAt (j)){
			  i++ ; j++ ; counter++;
		  }else {
			 j++;
		  }
	   }
	   return counter == s.length ();
   }
  
   public int[] TowSums(int [] arr , int target){
 	   HashMap<Integer , Integer > map = new HashMap<> ();
        int [] res = new int[2];
        map.put (arr[0] , 0);
	   for (int i = 1 ; i < arr.length ; i++){
		  if (map.containsKey (target - arr[i])){
		   res[0] = map.get (target - arr[i]) + 1;
		   res[1] = i + 1;
		  }else {
			 map.put (arr[i] , i);
		  }
	   }
	   return res;
   }
   
   

}
