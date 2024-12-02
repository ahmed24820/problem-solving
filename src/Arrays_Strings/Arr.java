package Arrays_Strings;
import java.util.*;
import java.util.logging.Logger;
public class Arr {
    Logger log = Logger.getLogger(String.valueOf(Arr.class));
    /*
     * this a solution for a problem that we check if there is a duplicated number in the array,
     * so we will use the hash set to check
     * */

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    /*
     * this solution for a problem to find the indices for two integers
     *  to get the target number from the array
     *  we use the hash map and make the key of the map the number in the array
     * and the value is the counter of the loop
     * */

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    /*
     * This solution is for a problem that we solve it By putting every word with each anagram list
     * By using the Hash map with the key of the word after sorting it. The value is the arraylist
     * that contains all the anagram words
     * */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] WordToChar = word.toCharArray();
            Arrays.sort(WordToChar);
            String SortedWord = String.valueOf(WordToChar);

            if (!map.containsKey(SortedWord)) {
                map.put(SortedWord, new ArrayList<>());
            }
            map.get(SortedWord).add(word);

        }
        return new ArrayList<>(map.values());
    }

    /*
     * this is a solution for a problem to find the product of array expect the element
     * we use the prefix and suffix we loop the array and multiply the prefix which is initialized with 1
     * and make a result array to put the multiply value in it, then
     * we make a suffix variable initialized by I then loop form the last to begin and put the values in
     * the result array by multiplying it with the old one in the prefix
     * */

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int suffix = 1, prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }

    /*
     *  this is a solution for a problem to solve the sudoku with a two dimensional array [9][9]
     * we need to check every row has a number from one to nine without repetition and the columns also
     * and check for every block with [3][3]
     * so we use the hashset as it does not allow the repetition
     * */

    public boolean isValidSudoku(char[][] arr) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> RowSet = new HashSet<>();
            HashSet<Character> ColumnSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = arr[i][j];
                char z = arr[j][i];
                if ((c != '.' && !RowSet.add(c)) || (z != '.' && ColumnSet.add(z))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!CheckBox(i, j, arr)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean CheckBox(int i, int j, char[][] arr) {
        int Rows = i + 3;
        int Columns = j + 3;

        for (int k = 0; k < Rows; k++) {
            Set<Character> set = new HashSet<>();
            for (int l = 0; l < Columns; l++) {
                char x = arr[k][l];
                if (x != '.' || !set.add(x)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * this solution for a problem that we want to count the maximum number of consequences of elements in it
     *
     * */
    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int counter = 0;
        List<Integer> Counters = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    counter++;
                } else {
                    Counters.add(counter);
                    counter = 0;
                }
            }
        }
        for (int x : Counters) {
            if (x > counter) {
                counter = x;
            }
        }
        return counter + 1;
    }


    /*
     * this is solution is for a problem to check if the string is palindrome with
     * characters and numbers only
     * we will use the regex expression to filter the string as [abc] is to check if the string has these characters
     * [^abc] check if the string does not have the characters
     */

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");  //this method takes a regex pattern and string as parameters
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*
     * this solution is for a problem to return the indexes of the two numbers that
     * there sums gives us the target number
     * */

    public int[] twoSums(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int[] answer = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                answer[0] = i + 1;
                answer[1] = j + 1;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return answer;
    }

    /*
     * we have a problem to find the maximum amount of water to store that the shape can not be slant(مائل)
     * so to calc that we now hava a rectangle, so we want to max the length and width to get  the max,
     * so we will check the beginning and the last and get the max from them and multiply with the difference between them
     * */

    public int maxArea(int[] height) {
        int begin = 0;
        int last = height.length - 1;
        int MaxArea = 0;
        while (begin < last) {
            // We will loop for every max area with every two pointers
            int CurrentArea = Math.min(height[begin], height[last]) * (last - begin);
            MaxArea = Math.max(CurrentArea, MaxArea);

            if (height[begin] < height[last]) {
                begin++;
            } else {
                last--;
            }
        }
        return MaxArea;
    }

    /*
     * the trapped water areas this problem is to calc the number of areas that the water traps into it,
     * so we will use the two pointers we will loop the array and get the max left, and every point we will
     * subtract the height of element with the max left or right
     * */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1,
                RightMax = height[right],
                LeftMax = height[left], res = 0;

        while (left < right) {
            if (LeftMax < RightMax) {
                left++;
                LeftMax = Math.max(height[left], LeftMax);
                res += LeftMax - height[left];
            } else {
                right--;
                RightMax = Math.max(height[right], RightMax);
                res += RightMax - height[right];
            }
        }
        return res;
    }

    /*
     *  this solution is to make the string in a zigzag Style, so we will use the string builder
     *  to connect the string and get the shape we want to have
     * */
    public String Convert_Zigzag(String s, int RowsNumber) {
        final int n = s.length();
        StringBuilder[] arr = new StringBuilder[RowsNumber];
        for (int i = 0; i < RowsNumber; i++) {
            arr[i] = new StringBuilder();
        }
        int i = 0;
        // we need to loop from up and down, so we will make to loops to make this
        while (i < n) {
            for (int j = 0; j < RowsNumber && i < n; j++) {
                arr[j].append(s.charAt(i++));
            }
            for (int j = RowsNumber - 2; j > 0 && i < n; j--) {
                arr[j].append(s.charAt(i++));
            }
        }
        StringBuilder Result = new StringBuilder();
        for (StringBuilder str : arr) {
            Result.append(str);
        }
        return Result.toString();
    }

    /*
    *  problem number 3043 in leetcode
    * we will make a hashmap to put every prefix in arr1 in it and then add every single character as a prefix,
    * then we will loop in another array
    * and check for the longest prefix that occurs in the map and the second array.
    */
      public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int num : arr1){
            String str = Integer.toString(num);
            String prefix ="";
            for (char c : str.toCharArray()){
               prefix += c;
               map.put(prefix , map.getOrDefault(map.get(prefix),0)+1);
            }
        }
            int maxPrefix = 0 ;

            for (int num : arr2){
              String str = Integer.toString(num);
              String commonPrefix ="";
              for (char c : str.toCharArray()){
                 commonPrefix += c;
                 if (map.containsKey(commonPrefix)){
                    maxPrefix = Math.max(maxPrefix,commonPrefix.length());
                 }
              }
            }
            return maxPrefix;
        }
        
        // 1497 leetcode problem
        public boolean canArrange(int []arr ,int k){
        int []freq = new int [k];
        
         for (int num : arr){
           int reminder = num % k;
           if (reminder < 0){
               reminder +=k;
           }
            freq[reminder]++;
         }
         
         if(freq[0] %2 != 0){
             return false;
         }
        for (int i = 1 ; i < k/2 ; i++){
          if (freq[i] != freq[k-i]){
              return false;
          }
        }
        return true;
      }

        public long dividePlayers(int[] skill) {
        if (skill.length == 0){
            return -1;
        }else if (skill.length == 1){
          return (long)skill[0];
        }
       
        Arrays.sort(skill);
            long answer = 0L;
        int unitSum = skill[0]+skill[skill.length-1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int i = 0 , j = skill.length - 1 , countOfTeams = 0;
        while (i < j){
         if (skill[i] + skill[j] == unitSum) {
             map.put(skill[i], Arrays.asList(skill[i], skill[j]));
             countOfTeams++;
         }else {
             break;
         }
          i++;
          j--;
         
        }
        
        for (int z = 0 ; z < countOfTeams ; z++){
          List<Integer> list = map.get(skill[z]);
          answer += list.get(0) * list.get(1);
          
        }
        
        return countOfTeams != skill.length/2 ? -1 : answer;
       }
       
         // 567 leet code
         public boolean checkInclusion(String s1, String s2) {
          int [] freq1 = new int[26] ; int [] freq2 = new int[26];
          
          for (int i = 0 ; i < s1.length();i++){
              freq1[(s1.charAt(i) - 'a')]++;
              freq2[(s2.charAt(i) - 'a')]++;
          }
          
          for (int i = 0 ; i < s2.length() - s1.length() ; i++){ // we substract here as the first substring is mine now
             if (matches(freq1,freq2)){
                 return true;
             }
             freq2[s2.charAt(i)-'a']--;
             freq2[s2.charAt(i + s1.length()) - 'a']++;
          }
          return matches(freq1,freq2);
         }
         private boolean matches(int []freq , int [] freq2){
          for (int i = 0 ; i < 26 ; i++){
             if (freq[i]!=freq2[i]){
                 return false;
             }
          }
          return true;
         }

         
         //2696 leetcode
        /*public int minLength(String s){   // this took 7 ms we can use the stack to solve with more better complexity
             String ab ="AB" , cd = "CD";
           while (s.contains(ab) || s.contains(cd)){
            s = s.replace(ab,"");
            s =  s.replace(cd,"");
             }
          return s.length();
        }
        */
        public int minLength(String s)
        {
          Stack<Character> stack = new Stack<>();
          for (int i = 0 ; i < s.length();i++){
            if (!stack.isEmpty() && s.charAt(i)=='B' && stack.peek()=='A' || s.charAt(i)=='D' && stack.peek()=='C'){
              stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
          }
           int answer = stack.size();
           return answer;
        }
        
        /*
        *  iterate and get Max number of closed brackets without opened one and then we want to make them balanced
        * so we will add 1 and supply to 2  if we have 3 closed brackets ( }}} {{{ ) we want to do 2 swaps operations to acieve balance
        * */
        public int minSwap(String s)
        {
         int temp = 0 , res = 0;
         for (char c : s.toCharArray()){
             if (c == '}'){
                 temp++;
             }else {
                 temp--;
             }
             res = Math.max(temp,res);
         }
         return ( res + 1 )/ 2;
        }
        
        // leetcode 921
        public int minAddToMakeValid(String s)
        {
         int res = 0;
         Stack<Character> stack = new Stack<>();
         for (char c : s.toCharArray()){
            if (c == '('){
             stack.push(c);
            }else {
              if (!stack.isEmpty()){
                char x = stack.peek();
                if (x == '('){
                    stack.pop();
                   continue;
                }else {
                   res ++;
                }
              }
              res++;
            }
         }
         return stack.size() + res;
        }
        
        // leetcode 1769  // Dynamic programming || N*2 Solution
        /*
        * if we have 10000 so the array will be filled with (0,1,2,3,4)
        * if we have 11000 so the array will be filled with (0,1,3,5,7)
        * if we have 11100 so the array will be filled with (0,1,3,6,9)
        * so our answer is changable by the count of 1 in the string so if we have only one 1 we will add one to the array
        * else if we have two we will add two for every element in the array
        * now if we have one in the last characters in string now we need to do a reveres loop to do the same function to the array
        * this solution costs o(n) complexity
        * */
        public int[] minOperations(String boxes)
        {
         int countOfOnes = 0 , total = 0 ;
         int [] answer = new int[boxes.length()];
         for (int i = 0 ; i < boxes.length() ; i++){
            total += countOfOnes;
            answer[i] = total;
            if (boxes.charAt(i)=='1'){
               countOfOnes++;
            }
         }
         countOfOnes = 0 ; total=0;
         for (int i = boxes.length() -1 ; i >= 0 ; i--){
             total += countOfOnes;
             answer[i] += total;
             if (boxes.charAt(i) == '1'){
                countOfOnes++;
             }
         }
         return answer;
        }

        // leetcode 2406
        /*
        * if we draw a line from the least start and max end and make a (start,end) point in it ,then calc the max intersection
        * between every two intervals then this is the number of groups that we can divide intervals to it without
        * */
        public int minGroups(int [][] intervals)
        {
            final int n = intervals.length;
            int [] startTimes = new int[n];
            int [] endTimes = new int[n];
            
            for (int i = 0 ; i < n ; i++){
                startTimes[i] = intervals[i][0];
                endTimes[i] = intervals[i][1];
            }
            //sort the end and start
            Arrays.sort(startTimes);
            Arrays.sort(endTimes);
            
            int groups = 0 , res = 0 , i = 0, j = 0 ;
           
             while ( i < n){
                 if (startTimes[i] <= endTimes[j]){
                    groups++; // all in the same interval
                     i++;
                }else {
                    groups--;
                    j++;
                }
              res = Math.max(res,groups);
            }
            return res;
        }
        
        // leetcode 88
        public void merge(int[] nums1, int m, int[] nums2, int n)
        {
            int i = 0 , j = 0 , x = 0 ;
            // we will add a new array that has the answer
            int [] ans = new int[m+n];
            // add the smallest numbers until anyone is done
            while (j < n && i < m){
                if (nums1[i] <= nums2[j])
                {
                   ans[x] = nums1[i];
                   i++ ;
                }
                 else
                {
                   ans[x] = nums2[j];
                   j++ ;
                }
	            x++;
            }
              // check if nums1 is already entered if not we will add them
                while (i < m ){
                   ans[x++] = nums1[i++];
                }
                // like nums1
                while (j < n ){
                    ans[x++] = nums2[j++];
                }
                // we will copy the array to nums1 as the problem wants.
	        System.arraycopy (ans, 0, nums1, 0, nums1.length);
            }
            
        public int removeElement(int[] nums, int val)
        { // make a list to save elements without elements with the val
             List<Integer> ans = new ArrayList<>();
	        for (int num : nums) {
		        if (num != val) {
			        ans.add (num);
		        }
	        }
             // add the result in the array
            for (int i = 0 ; i < ans.size () ; i++){
               nums[i] = ans.get (i);
            }
              // put the remain values with any values
             for (int i = ans.size () ; i < nums.length ; i++){
               nums[i] ='-';
            }
            // the size for new array without elements with the val
	        return  ans.size ();
        }
        
        public int removeDuplicates(int[] nums)
        {
        /*  HashMap<Integer , Integer> map = new HashMap<> ();
          int j = 0 , size = 0;
          for (int x : nums){
             if (!map.containsValue(x)){
                map.put (j++ , x);
                size++;
             }
          }
          int [] ExcpectArray = new int[size];
          for (int i = 0 ; i < size ; i++){
            ExcpectArray[i] = map.get(i);
          }
          for (int i = 0 ; i < size ; i++){
             nums[i] = ExcpectArray[i];
          }
          return size;
          
         */ // took too much time
            int j = 0 ;
            // check if the following number is not equal as it is already
            // sorted if not equal we will add the number to the array else continue
            for (int i = 1 ; i < nums.length ; i++){
               if (nums[j] != nums[i]){
                  nums[j+1] = nums[i];
                  j++;
               }
            }
            // return the size of the elements in array
            return j + 1;
          }
          
        // leetcode 80
        public int removeDuplicates2(int[] nums)
        {
            int j = 0;
            HashMap<Integer , Integer > map = new HashMap<> ();
            map.put (nums[j] , map.getOrDefault (nums[j],0) + 1);
            for (int i = 1 ; i < nums.length ; i++ ){
              if (nums[j] == nums[i] && map.get (nums[j]) < 2){
                  map.put (nums[j] , map.getOrDefault (nums[j],0) + 1);
                nums[j+1] = nums[i];
                j++;
              } else if(nums[j] != nums[i]) {
                  map.put (nums[i] , map.getOrDefault (nums[i],0) + 1);
                  nums[j+1] = nums[i];
                  j++;
              }
            }
            return j + 1;
            /*
            if(nums.length < 2) {
                return nums.length;
            }
            
            int j = 2;
            for(int i = 2; i < nums.length; i++) {
                if(nums[i] != nums[j - 2]) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            
            for (int x : nums){
                System.out.print (x + " ");
            }
            
            return j;
            */
        }
       
        // leetcode 169
        public int majorityElement(int[] nums)
        {
         int majority = 0;
         HashMap<Integer , Integer > map = new HashMap<> ();
         for (int x : nums){
            map.put (x , map.getOrDefault (x,0) +  1 );
         }
         for (int x : map.keySet ()){
           if ( map.get (x) > nums.length / 2){
             majority = x;
             break;
           }
         }
         return majority;
        }
     
     }
        
     










