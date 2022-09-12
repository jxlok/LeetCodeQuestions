//Problem Statement: Given the root of a binary tree, return the inorder traversal of its nodes' values.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}


public class InOrder {

    public static List<Integer> inorderTraversal(TreeNode root) {

        //return variable
        List<Integer> result = new LinkedList<>();

        //if empty
        if(root==null){
            return result;
        }

        //helper function for traversing
        traverse(root, result);

        return result;

    }

    public static void traverse(TreeNode root, List<Integer> result){

        //go left
        if(root.left!=null){
            traverse(root.left, result);
        }

        //then root
        result.add(root.val);

        //then right
        if(root.right!=null){
            traverse(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversal(root));
    }
}
