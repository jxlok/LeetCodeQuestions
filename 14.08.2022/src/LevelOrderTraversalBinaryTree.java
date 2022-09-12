//Problem Statement: Given the root of a binary tree, display the node values at each level.

//Time complexity: O(n^2)
//Space complexity: O(1)
import java.util.*;

public class LevelOrderTraversalBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void levelOrderDisplay(TreeNode root){

        //if tree is empty
        if(root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        //while not finished with all outputs
        while(queue.size()!=0){

            //get count at current row
            int count = queue.size();

            //while current queue (child nodes at current row not added) not empty
            while(count-->0){
                //take from queue and print out value
                TreeNode curr = queue.poll();
                System.out.print(curr.val+" ");

                //add left and right child nodes into queue
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }

            System.out.println();

        }
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(100, new TreeNode(50, new TreeNode(25), new TreeNode(75)), new TreeNode(200, null, new TreeNode(350)));
        levelOrderDisplay(test);
    }
}
