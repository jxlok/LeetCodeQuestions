//Problem Statement: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.


import com.sun.source.tree.Tree;

//Definition for a binary tree node.
class Node {
   int val;
   Node left;
   Node right;
   Node() {}
   Node(int val) { this.val = val; }
   Node(int val, Node left, Node right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }
}
 
public class validBST {

    static Node prev = null;
    //inorder traversal
    public static boolean isValidBST(Node root) {

        if(root==null){
            return true;
        }

        //start bottom left and check after value
        if(!isValidBST(root.left)){
            return false;
        }

        //if prev is greater than current
        if(prev!=null && prev.val>root.val){
            return false;
        }

        //iterate previous pointer
        prev = root;

        return isValidBST(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(2, new Node(2), new Node(2));

        System.out.println(isValidBST(root));
    }
}
