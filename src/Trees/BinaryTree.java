package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {

    private TreeNode root = null;

    public TreeNode CreateBinaryTree() {
        TreeNode first = new TreeNode(10); // we are going to make a binary tree manually and set leaves
        TreeNode second = new TreeNode(20);
        TreeNode third = new TreeNode(30);
        TreeNode fourth = new TreeNode(40);
        TreeNode fifth = new TreeNode(50);
        TreeNode sixth = new TreeNode(60);
        TreeNode seventh = new TreeNode(70);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = sixth;
        third.right = seventh;
        return root;
    }

    /*
     * that's show us the trace of the tree with the recursive way we print the (root-left-right)
     */

    public void PreOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        System.out.print(root.val + " \t");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    /*
     * that's show us the trace of the tree with the recursive way we print the (left-root-right)
     */
    public void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " \t");
        InOrder(root.right);

    }

    /*
     * that's show us the trace of the tree with the recursive way we print the (right-left-root)
     */
    public void PostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        PostOrder(root.right);
        PostOrder(root.left);
        System.out.print(root.val + " \t");

    }

    /*
     * this is a solution for a problem to convert every right and left node in the tree
     * we will use the recursion by swapping every node we reach by the opposite of it
     * */
    public TreeNode InvertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        InvertTree(root.left);
        InvertTree(root.right);

        return root;
    }

    /*
     * this is the level order traversal for a tree using the queue
     * */
    public void LevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode demo = queue.poll();
            System.out.print(demo.val + "\t");
            if (demo.left != null) {
                queue.offer(demo.left);
            }
            if (demo.right != null) {
                queue.offer(demo.right);
            }
        }
    }
    /*
     * How to find the max number in the tree, we will use the recursive way
     * */

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > res) {
            res = left;
        }
        if (right > res) {
            res = right;
        }
        return res;
    }

    /*
     * this is a solution for a problem to build a tree with the 2D array that has([parent - child - is_left?] )
     * we here want to know the parent and every node childes and create a tree with this information
     * we will use the hash set to keep the childes in it and the number that does not appear is the parent
     * then we make a hashmap with the parent is a key and array that has left and right in the value
     *  */
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            map.putIfAbsent(parent, new int[]{-1, -1});
            children.add(child);

            if (isLeft) {
                map.get(parent)[0] = child;
            } else {
                map.get(parent)[1] = child;
            }
        }

        // now we want to know the root we will loop in the set to check for the parent
        // if it is not present that is the root
        int head = 0;
        for (int i : map.keySet()) {
            if (!children.contains(i)) {
                head = i;
                break;
            }
        }
        return ConstructTree(head, map);
    }

    // now we want to make the tree and set every left and right node for each parent
    public TreeNode ConstructTree(int CurrentValue, HashMap<Integer, int[]> Directions) {
        TreeNode Current = new TreeNode(CurrentValue);
        if (Directions.containsKey(CurrentValue)) {
            int[] children = Directions.get(CurrentValue);
            if (children[0] != -1) {
                Current.left = ConstructTree(children[0], Directions);
            }
            if (children[1] != -1) {
                Current.right = ConstructTree(children[1], Directions);
            }
        }
        return Current;
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }

    }

    /*
     * this solution to find the max number of nodes that we need to go through them to
     * reach to the Farest node in the tree
     * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);


    }

    /*
     * this problem solution to find the max diameter that loop in the tree
     * here we recursively get the big number of edges from the left, and right then we sum them
     * then we get the tallest path from right and left (not from the root)
     * */
    public int MaxDiameter(TreeNode root) {
        Length(root);
        return maxDia;
    }

    int maxDia = 0;

    public int Length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Length(root.left);
        int right = Length(root.right);
        int currentDia = left + right;
        maxDia = Math.max(maxDia, currentDia);
        return 1 + Math.max(left, right);
    }

    /*
    *  this code to check if the tree is a balanced tree which every right and left node has(0 or 1 or -1)
    * difference between themselves
    * */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left - right) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
    /*
    * this solution to check if the two trees are equals or not by recursive every node
    * and check if it equals the corresponding in another tree
     * */

    public boolean isSameTree(TreeNode p, TreeNode q) {
     if(p == null || q == null ){
         return p == null && q == null;
     }
     if(p.val != q.val){
         return false;
     }
         return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(subRoot == null && root != null || root == null && subRoot == null){
            return true;
        }
        if (subRoot != null && root == null){
            return false ;
        }
        if( isSameTree(root ,subRoot))return true;
        return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }

       /*
       * this is a solution to traverse the tree with level order with BFS
       * we use the queue to set the fifo style, and we get every level in a list then
       * we collect all lists in one result list to get the answer
       * */

          public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> FinalList =new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> level =new ArrayList<>();
          for(int i = 0; i < length ; i++){
             TreeNode node = queue.poll();
             if(node != null) {
                 queue.offer(node.left);
                 queue.offer(node.right);
              level.add(node.val);
             }
             if(!level.isEmpty()){
           FinalList.add(level);
             }
          }
        }
        return FinalList;
       }

       public boolean isValidBST(TreeNode root) {

      return isvalid(root ,Integer.MIN_VALUE,Integer.MIN_VALUE );

        }

        public boolean isvalid(TreeNode root , long min , long max){
             if(root == null){
                 return true;
             }
             if(root.val <= min || root.val >= max){
                 return false;
             }
             boolean isleft = isvalid(root.left , min , root.val);
             if(isleft){
                isvalid(root.right , root.val, max);
               return true;
             }
             return false;
         }

        /*
        * this is problem name is the lowest common ancestor we need to find the nearest node to the two
        * nodes with constraints that p and q are descendants for this node
        * */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root.val > p.val && root.val > q.val){ // that mean that the nodes are in the left subtree and has another ancestor
                return lowestCommonAncestor(root.left,p,q);
            }
            if (root.val < p.val && root.val < q.val){ // that mean that the nodes are in the left subtree and has another ancestor
                return lowestCommonAncestor(root.right,p,q);
            }
         return root;
        }

        // here we need to show the right side if it is in ascending order
        // we will use the bfs with queue
        public List<Integer> rightSideView(TreeNode root){
            List<Integer> result =new ArrayList<>();
            Queue<TreeNode>queue = new LinkedList<>();
             if (root == null){
                 return result;
             }
            queue.offer(root);
            while (!queue.isEmpty()){
              int size = queue.size();
              for (int i = 0; i < size ; i++){
                  TreeNode node = queue.poll(); // that is make the queue empty after every loop in it
                 if (i == 0) result.add(node.val); // this helps us to only get the right side as the first in first out
                 if (node.right != null) queue.offer(node.right);
                 if (node.left != null) queue.offer(node.left);
              }
             }

          return result;
        }
        /*
        * this problem solution to find nodes that has no nodes that has value greater than it
        * in the path from the root to it,
        * we will use the dfs and get the max value for every side and check if it greater than it.
        * we will increase the result by one
        * */

        public int goodNodes(TreeNode root , int MaxVal){
            return dfs(root,root.val);
        }
        int result = 0;
        public int dfs(TreeNode root , int max){
            if (root == null){
                return 0 ;
            }
          if (root.val >= max){
             result = 1;
          }else {
              result = 0;
          }
          max = Math.max(max , root.val);

          result += dfs(root.left , max);
          result += dfs(root.right, max);
          return result;
        }

           /*
           * this problem to get the kth of the element in the BST we will use the inorder traversal to find
           * the number
           * */
           public int kthSmallest(TreeNode root, int k) {
               Stack<TreeNode>stack = new Stack<>();
               int n = 0 , answer = 0;
               TreeNode current =root;
               while (current != null || !stack.isEmpty()){
                   while (current !=null){
                      stack.add(current);
                      current = current.left;
                   }
                   current = stack.pop();
                   n++;
                   if(n == k){
                     answer = current.val;
                   }
                   current = current.right;
               }
                return answer;
            }

            /*
            * know we have an inorder traversal and preorder traversal for a tree
            * we need to construct the main tree from these two trees
            * we will get the root from the preorder as the first element is always the root
            * then we search for it in an inorder array and the elements that are before are in the left
            * the elements after are on the right side
            * */
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                return GetTree(0,0,inorder.length - 1,preorder,inorder);
             }
             public TreeNode GetTree(int preStart , int inStart , int inEnd , int[]preorder , int[] inorder){
                if (preStart > preorder.length-1 || inStart > inEnd){
                  return null;
                }
                TreeNode root = new TreeNode(preorder[preStart]); // to Get the root from the preorder array as the first element

                // we will check for it in the inorder array and get the index of it
                  int index = 0;
                 for (int i = inStart; i <= inEnd ; i++){
                    if (root.val == inorder[i]){
                       index = i;
                    }
                }
                  root.left =GetTree(preStart + 1 , inStart , index - 1, preorder, inorder);
                  root.right =GetTree(preStart + index - inStart + 1 , index + 1 , inEnd , preorder, inorder);
                 return root;
             }


}