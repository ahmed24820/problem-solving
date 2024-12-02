package Hashing;
import java.util.*;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class HS {

    Logger log=Logger.getLogger("HS.class");
    /*
    * this is a problem need me to get the longest substring of the string
    * without any repeat of characters
    * we will use the slide window algorithm to get the substring it will take o(n^2) unless the brute force
    *
    * */

    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        int maxLength = 0 , i = 0 , j = 0 ;
        HashSet<Character> set=new HashSet<>();
       while (i < n){
         char c = s.charAt(i);
        while (set.contains(c)){
            set.remove(s.charAt(j));
            j++;
        }
        set.add(c);
        i++;
        maxLength = Math.max(maxLength , i-j);
       }
        return maxLength;
      }

    public int lengthOfLastWord(String s) {
        int counter = 0, n = s.length();
        while(s.charAt(n-1) == ' '){
            n--;
        }
//        log.info("the length right now is >>"+n);
        if(n==1){
            return 1;
        }
        for(int i = n-1 ;i > 0 ;i--){
            if (s.charAt(i)!=' '){
                counter++;
            }else {
                break;
            }
        }
        return  counter;
    }
    public String intToRoman(int num) {
        /*
        *  we have a constraint that allow us if we have four we do not use IIII we can use IV that is better
        * that is for nine and 40 and 90 and 900 and 400
        * */

             StringBuilder answer = new StringBuilder();
        HashMap<Character,Integer> set=new HashMap<>();
        set.put('I',1);set.put('V',5);set.put('X',10);set.put('L',50);set.put('C',100);set.put('D',500);set.put('M',1000);
         while (num>0){

    //             log .info("the number now is >> " +"  " + num);
             if ( num > 0 && num < 5 && num !=4) {
                 answer.append('I');
                 num -= set.get('I');
             }

                else if (num==9) {
                    answer.append("IX");
                    num-= set.get('X')-1;
                }
                     else if (num >= 4 && num < 5) {
                         answer.append("IV");
                         num-= set.get('V')-1;
                     }
                else if (num >= 40 && num < 50) {
                    answer.append("XL");
                    num-= set.get('L')-10;
                }
                else if (num >= 90 && num < 100 ) {
                    answer.append("XC");
                    num-= set.get('C')-10;
                }
                else if (num >= 400 && num < 500 ) {
                    answer.append("CD");
                    num-= set.get('D')-100;
                }
                else if (num >= 900 && num < 1000 ) {
                    answer.append("CM");
                    num-= set.get('M')-100;
                }
                     else if (num >= 5 && num < 10) {
                         answer.append('V');
                         num-=set.get('V');
                     }
                     else if (num >= 10 && num < 50) {
                         answer.append('X');
                         num-=set.get('X');
                    }
                     else if (num >= 50 && num < 100) {
                         answer.append('L');
                         num -= set.get('L');
                     }
                     else if (num >= 100 && num < 500) {
                         answer.append('C');
                         num -= set.get('C');
                     }else if (num >= 500 && num < 1000) {
                         answer.append('D');
                         num -= set.get('D');
                     }
                     else if (num >= 1000) {
                     answer.append('M');
                     num -= set.get('M');
                   }
                 }
        return answer.toString();
            }
    public int removeDuplicates(int[] nums) {
      int size =0;
      HashMap<Integer,Integer>hashMap=new HashMap<>();
      for(int i=0 ; i < nums.length ; i++){
          if(!hashMap.containsKey(nums[i])){
              hashMap.put(nums[i],i);
              size++;
          }
      }
        int[] expectedAnswer = new int [size];
      for (int i = 0 ; i < size ; i++){
         expectedAnswer[i]=hashMap.keySet().stream().toList().get(i);
          nums[i]=expectedAnswer[i];
      }
      for (int i=0;i<size;i++) {
          for (int j = i + 1; j < size; j++) {
              if (nums[i] > nums[j]) {
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j] = temp;
              }
          }
          System.out.println(nums[i]);
      }
      return size;
     }

    public int removeElement(int[] nums, int val) {
        int size =0;
        HashMap<Integer,Integer>hashMap=new HashMap<>();
        for (int num : nums) {
            if (num != val) {
                hashMap.put(num, 0);
                size++;
            }
        }
        int[] expectedAnswer = new int[size];
        for (int i=0;i<size;i++){
            expectedAnswer[i]=hashMap.keySet().stream().toList().get(i);
            nums[i]=expectedAnswer[i];
        }
        return size;
    }

    /*
    * this solution to solve a problem to find the duplicated number without any modifying in the array
    * we will use the hash map, and we will put the element and the number that this number occurs in the array
    * */
    public int findDuplicate(int[] nums) {
      int answer = 0;
        Map <Integer , Integer> map = new HashMap<>();
        for (int i : nums){
            int count = (map.containsKey(i))? map.get(i) + 1 : 0; // we will check if the hash has the number, if true,
            // we will put the counter =1 else we will put it 0
          map.put(i , count);
        }
        for (int i : nums){
          if(map.get(i) >= 1){
              answer = i ;
           break;
          }
        }
        return answer;
    }


     public String[] uncommonFromSentences(String s1, String s2) {
        String finalString = s1 +" " + s2;
        HashMap<String , Integer> map = new HashMap<>();
        String []words = finalString.split(" ");
        for (String word : words){
           map.put(word ,map.getOrDefault(word,0) +1);
        }
        List<String> result = new ArrayList<>();

        for (Map.Entry<String ,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }
         String [] answer = new String[result.size()];

        for (int i = 0 ; i < result.size();i++){
           answer[i] = result.get(i);
        }

        return answer;
     }
     
     // 1331 leetcode problem
    public int[] arrayRankTransform(int[] arr)
    {
     HashMap<Integer,Integer> map = new HashMap<>();
     int [] copyArr = new int[arr.length];
     
     for (int i = 0 ; i < arr.length ; i++){
        copyArr[i] = arr[i];
     }
     
     Arrays.sort(copyArr);
     
     int [] answer = new int[arr.length];
     int counter = 0;
     for (int i = 0 ; i < arr.length ; i++){
         if (map.containsKey(copyArr[i])){
            map.put(copyArr[i],map.get(copyArr[i]));
         }else {
         map.put(copyArr[i],++counter);
     }
     }
     for (int i = 0 ; i < arr.length ; i++){
       answer[i] = map.get(arr[i]);
     }
     return answer; // (n log n)
    }
    
     // leetcode 1590
    public int minSubarray(int []nums , int p)
    {
     long sum = (long) Arrays.stream(nums).sum();
     int reminder = (int) sum % p;
     
     if (reminder == 0){
         return 0;
     }
     int ans = nums.length;
     HashMap<Integer , Integer> map = new HashMap<>();
     int prefix = 0;
     for (int i = 0 ; i < nums.length ; i++){
       prefix += nums[i];
       prefix %= p ;
       
       int target = (prefix - reminder + p) % p;
       
       log.info(" target now in " + i + " is " + target);
       
         log.info(" prefix now in  " + i + " is " + prefix);
       
       if (map.containsKey(target)){
         ans = Math.min(ans , i - map.get(target));
       }
       map.put(prefix , i);
     }
     return ans == nums.length ? -1 : ans;
    }
    
    public boolean canConstruct(String ransomNote, String magazine)
    {
     HashMap <Character , Integer> map = new HashMap<> ();
     
     for (char x : magazine.toCharArray ()){
        map.put (x , map.getOrDefault ( x,0) + 1);
     }
     for (char x : ransomNote.toCharArray () ){
         // the zero condition as we will reduce the value when we find it
        if ( !map.containsKey (x) || map.get (x) == 0 ){
           return false ;
        }
        map.put (x ,  map.getOrDefault ( x,0) - 1);
     }
     ransomNote.indexOf (magazine);
     return true;
    }
    
    
 
}






