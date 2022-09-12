//Problem Statement: Connect the sibling pointer to the next node in the same level.
// The last node in each level should point to the first node of the next level in the tree.

import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(n)
//Space Complexity: O(n)
public class ConnectSiblingsBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

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

    public static void connect(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //while all nodes not iterated through
        while(queue.size()!=0){

            //take node
            TreeNode curr = queue.poll();

            //add left and right child node
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }

            //set next to top of queue
            curr.next = queue.peek();

        }
    }

    public static void printNext(TreeNode root){

        while(root!=null){
            System.out.print(root.val+"->");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(100, new TreeNode(50, new TreeNode(25), new TreeNode(75)), new TreeNode(200, null, new TreeNode(300, null, new TreeNode(350))));
        connect(test);
        printNext(test);
    }
}
