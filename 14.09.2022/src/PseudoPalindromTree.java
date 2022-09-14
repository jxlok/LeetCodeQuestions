//Problem Statement: Given a binary tree where node values are digits from 1 to 9.
// A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the
// node values in the path is a palindrome.
//
//Return the number of pseudo-palindromic paths going from the root node to leaf nodes.


import java.util.HashMap;
import java.util.Stack;

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

//Depth first search, preorder traversal: use stack
//Recursive implementation also available

public class PseudoPalindromTree {

    static int count=0;

    public static int pseudoPalindromicPaths (TreeNode root) {
//
//        //final count
//        int count=0;
//
//        //stack for traversing
//        Stack<TreeNode> stack = new Stack<>();
//
//        //hashmap for checking palindrome, number and count
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        //add root
//        stack.add(root);
//
//        //loop until all nodes checked
//        while(stack!=null){
//
//            TreeNode curr = stack.pop();
//
//            //add to hashmap
//            if(hashMap.containsKey(curr.val)) {
//                hashMap.put(curr.val, hashMap.get(curr.val) + 1);
//            }
//            else{
//                hashMap.put(curr.val, 1);
//            }
//
//
//            //add children to stack
//            if(curr.left!=null){
//                stack.add(curr.left);
//            }
//            if(curr.right!=null){
//                stack.add(curr.right);
//            }
//
//            //if child node and valid palindrome, increment count
//            if(curr.left==null && curr.right==null && checkPalindrome(hashMap)){
//                hashMap.remove(curr.val);
//                count++;
//            }
//
//        }
//
//        return count;

        //arr for palindrome values
        int[] arr = new int[10];

        traverse(root, arr);

        return count;
    }

    public static void traverse(TreeNode curr, int[] arr){

        if(curr==null){
            return;
        }


        if(curr.left==null && curr.right==null){

            arr[curr.val]++;

            if(checkPalindrome(arr)){
                count++;
            }

            arr[curr.val]--;
            return;
        }


        //add to arr
        arr[curr.val]++;

        //add children to stack
        traverse(curr.left, arr);
        traverse(curr.right, arr);

        //remove from arr once again
        arr[curr.val]--;
    }

    public static boolean checkPalindrome(int[] arr){

        int odd = 0;

        for(int val : arr){
            if(val%2==1){
                odd++;
            }
            if(odd>1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)));
        System.out.println(pseudoPalindromicPaths(root));
    }
}
