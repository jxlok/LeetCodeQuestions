//Problem Statement: Given the root of a binary tree,
// construct a string consisting of parenthesis and integers from a
// binary tree with the preorder traversal way, and return it.
//
//Omit all the empty parenthesis pairs that do not affect the one-to-one
// mapping relationship between the string and the original binary tree.

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


public class BinaryTreeToString {

    public static String tree2str(TreeNode root) {

        StringBuilder result = new StringBuilder();

        createString(root, result);

        return result.toString();
    }

    public static void createString(TreeNode root, StringBuilder result){

        //add val
        result.append(root.val);

        //if have children, add start bracket and check for their children
        if(root.left!=null){
            result.append("(");
            createString(root.left, result);
            //close brackets
            result.append(")");
        }

        if(root.right!=null){
            //if right not empty but left empty, add empty brackets for left
            if(root.left==null){
                result.append("()");
            }

                result.append("(");
            createString(root.right, result);
            //close brackets
            result.append(")");
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(tree2str(root));
    }
}
