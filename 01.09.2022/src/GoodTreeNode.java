//Problem Statement: Given a binary tree root, a node X in the tree is named good if in the path from root to X
// there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.

import java.util.LinkedList;

public class GoodTreeNode {

    //TreeNode data structure
    public static class TreeNode{
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

    public static int goodNodes(TreeNode root) {

        //counter including root node by default
        LinkedList<TreeNode> goodNodes = new LinkedList<>();
        int largest = root.val;

        //check root node and its following nodes
        checkNode(root, largest, goodNodes);

        return goodNodes.size();
    }

    public static void checkNode(TreeNode node, int largest, LinkedList<TreeNode> goodNodes){

        //if checked node is the largest in its path
        if(node.val >= largest) {
            //increase new largest
            largest = node.val;
            //add node to goodNodes
            goodNodes.add(node);
        }

        //check children nodes
        if(node.left !=null){
            checkNode(node.left, largest, goodNodes);
        }
        if(node.right!=null){
            checkNode(node.right, largest, goodNodes);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        System.out.println(goodNodes(node));
    }
}
