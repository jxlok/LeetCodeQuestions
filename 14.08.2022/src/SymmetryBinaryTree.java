//Problem Statement: Given a binary tree,
// write a program that will return true if the binary tree is a mirror image of itself,
// and false if it is not.


import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(n)
//Space Complexity: O(n)
public class SymmetryBinaryTree {

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

    public static boolean checkSymmetry(TreeNode root){

        //queue for left side
        Queue<TreeNode> queueL = new LinkedList<>();
        queueL.add(root.left);

        //queue for right side
        Queue<TreeNode> queueR = new LinkedList<>();
        queueR.add(root.right);

        //while one side not exhausted
        while(queueL.size() != 0 && queueR.size()!=0){

            //take from each queue
            TreeNode left = queueL.poll();
            TreeNode right = queueR.poll();

            //compare
            if(left.val!=right.val){
                return false;
            }

            //add left nodes (L, R)
            if(left.left!=null){
                queueL.add(left.left);
            }
            if(left.right!=null){
                queueL.add(left.right);
            }

            //add right nodes (R, L)
            if(right.right!=null){
                queueR.add(right.right);
            }
            if(right.left!=null){
                queueR.add(right.left);
            }
        }

        //extra left over
        if(queueL.size() != 0 || queueR.size()!=0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(10, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(4, new TreeNode(2), new TreeNode(1)));
        System.out.println(checkSymmetry(test));
    }

}
