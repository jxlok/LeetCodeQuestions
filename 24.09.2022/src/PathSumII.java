//Problem Statement: Given the root of a binary tree and an integer targetSum, return all root-to-leaf
// paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//
//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class PathSumII {

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        //return empty list, if no root
        if(root==null){
            return result;
        }

        List<Integer> path = new LinkedList<>();

        int sum=0;

        //use helper to fill result
        helper(root, targetSum, sum, path);

        return result;
    }

    public static void helper(TreeNode root, int targetSum, int sum, List<Integer> path){

        //add value of node to path
        path.add(root.val);

        sum+=root.val;

        //if leaf and if target sum, add to resulting list
        if(root.left==null && root.right==null && sum==targetSum){
            result.add(new LinkedList<>(path));
        }

        //check left and right children
        if(root.left!=null){
            helper(root.left, targetSum, sum, path);
        }

        if(root.right!=null){
            helper(root.right, targetSum, sum, path);
        }

        //remove last input in path
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(pathSum(root, 22));
    }
}
