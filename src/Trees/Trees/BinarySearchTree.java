package Trees.Trees;

public class BinarySearchTree {

    /*
    * this is how we insert in the BST we first check if root is null we make a root with the value we have
    * then we recursively check for every value and right place we can put in it left or right
    * then we check every node we add
    * */

    public TreeNode insert(TreeNode root , int value){
        if(root == null){
          root = new TreeNode(value);
          return root;
        }
        if(value < root.val){
           root.left = insert(root.left , value);
        }else {
           root.right = insert(root.right, value
           );
        }
        return root;
    }
}
