package Trees.Trees;

import java.util.Stack;

public class IterativeTraversal {

     /*
     * now we want to traverse the tree without a recursion, so we will use stack approach to do that as the last one added will
     * come first we will put the left leaf in the last to get it first then middle right
     * */
    public void PreOrder(TreeNode root){
       if(root == null){
         return;
       }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
       while (!stack.isEmpty()){
         TreeNode demo = stack.pop();
           System.out.print(demo.val + "\t");
         if(demo.right != null){
           stack.push(demo.right);
         }
         if (demo.left != null){
             stack.push(demo.left);
         }
       }
    }

    public void InOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode demo = root;
        while (!stack.isEmpty() || demo !=null){
            if(demo != null){
               stack.push(demo);
               demo=demo.left;
            }else {
                demo = stack.pop();
                System.out.print(demo.val + "\t");
                demo = demo.right;
            }
        }
    }

}
