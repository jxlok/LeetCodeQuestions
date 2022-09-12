//Problem Statement: Given the root of a binary tree, return the same tree
// where every subtree (of the given tree) not containing a 1 has been removed.
//
//A subtree of a node node is node plus every node that is a descendant of node.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


public class TreePruning {

    public TreeNode pruneTree(TreeNode root) {
        //recursive implementation, if leaf and 0 then null
        if(root==null){
            return null;
        }
        //deal with children before current node to find if current node is valid
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val==0 && root.left == null && root.right == null){
            return null;
        }

        return root;


    }


}
