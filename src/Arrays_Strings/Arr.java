package Arrays_Strings;
import java.util.*;
import java.util.logging.Logger;
public class Arr {
    Scanner sc = new Scanner(System.in);
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

     }










