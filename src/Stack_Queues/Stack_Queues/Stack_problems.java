package Stack_Queues;

import Stack_Queues.Stack_Queues.Node;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;

public class Stack_problems {

    Logger log= Logger.getLogger(String.valueOf("OzO.class"));
    private Node top;

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] arr=s.toCharArray();
        for (char i:arr) {
          if(i == '{' || i == '(' || i == '['){
              stack.push(i);
          }else if(i == '}'){
            if(!stack.isEmpty()){
              char x=stack.peek();
              if(x == '{'){
                 stack.pop();
              }else {
                  return  false;}}
          }else if(i == ']'){
              if(!stack.isEmpty()){
                  char x=stack.peek();
                  if(x == '['){
                      stack.pop();
                  }else {
                      return  false;}}
          }else if(i == ')'){
              if(!stack.isEmpty()){
                  char x=stack.peek();
                  if(x == '('){
                      stack.pop();
                  }else {
                      return  false;
                  }}}}
         if(stack.isEmpty()){
        return true;
         }
         else
             return false;}



             /* these functions are for stacks to push and pop and peak (Basics)
               we also make a function to return the min data that added to the stack
               we make a node class and do
                * */

           int length;
           public void push(int data){
            if(top == null){
               top=new Node(data,data,null);
            }else {
               Node NewNode = new Node(data,Math.min(data,top.minData),top);
               top = NewNode;
               length++;
            }
           }
        
           public int peak(){
              if(top==null){
                 return 0;
              }
                 return top.data;
           }
        
           public int pop(){
               int result=0;
               if(top==null){
                   return 0;
               }else {
               result=top.data;
               top = top.next;
               length--;
               }
               return result;
           }
           
           public int MinData(){
               return top.minData;
           }

             /*
           * this solution is to solve the Reverse Polish Notation.(the operators follow their operands)
           * so we use the stack and check if the variable is an operators so we get the two operands before
           * and supply the operator and finally get the result
           * */
            public int evalRPN(String[] tokens){
              Stack<Integer>stack=new Stack<>();
              for (String str : tokens) {
                  if (Objects.equals(str, "+")) {
                      int num1 = stack.pop();
                      int num2 = stack.pop();
                      int result = num2 + num1;
                      stack.push(result);
                  } else if (Objects.equals(str, "*")) {
                      int num1 = stack.pop();
                      int num2 = stack.pop();
                      int result = num2 * num1;
                      stack.push(result);

                  } else if (Objects.equals(str, "/")) {
                      int num1 = stack.pop();
                      int num2 = stack.pop();
                      int result = num2 / num1;
                      stack.push(result);

                  } else if (Objects.equals(str, "-")) {
                      int num1 = stack.pop();
                      int num2 = stack.pop();
                      int result = num2 - num1;
                      stack.push(result);
                  } else {
                      stack.push(Integer.parseInt(str));
                  }
              }
               return stack.pop();
                }

               /*
               * this solution helps us to get the number of days we will stay to get more worm temperature
               * we need to return an array with values of the days we want to stay
               * */
            public int [] dailyTemperatures(int[] temps) {
                  final int n=temps.length;
                    int[] results = new int[n];
                    Stack<Integer> stack = new Stack<>();
                    // we will put the indexes in the stack to catch the number of days by sub the indexes
                    for (int i=0;i<n;i++){
                         while (!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                             results[stack.peek()]=i-stack.pop();
                         }
                        stack.push(i);
                    }
                    return results;
                }

            // leetcode 962
            public int maxWidthRamp(int[] nums) {
                int maxWidth = 0 , n = nums.length;
                Stack<Integer> stack = new Stack<>();
                
                // step 1 : build a decreasing stack indices
                for (int i = 0 ; i < n ; i++){
                   if (stack.isEmpty() || nums[stack.peek()] > nums[i]){
                       stack.push(i);
                   }
                }
                
                // step 2 : traverse from the end and find the max width
                for (int i = n-1 ; i >= 0 ; i--){
                   if (!stack.isEmpty() || nums[stack.peek()] <= nums[i]){
                      maxWidth = Math.max(maxWidth,i - stack.pop());
                   }
                }
                
                return maxWidth;
            }

           

}






