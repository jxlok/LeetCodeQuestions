//Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
//
//For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1)
// and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
//
//The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index
// starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the
// same row and same column. In such a case, sort these nodes by their values.
//
//Return the vertical order traversal of the binary tree.

import java.util.*;

public class VerticalOrderTraversal {

    public static class TreeNode {
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

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        //hashmap holding positions and values
        LinkedHashMap<List<Integer>, List<Integer>> hashMap = new LinkedHashMap<>();

        int i=0;
        int j=0;

        //add node position and value to Hashmap
        addToHashmap(root, hashMap, i, j);

        TreeMap<Integer, List<Integer>> result = mergeHashMap(hashMap);

        return new ArrayList<>(result.values());
    }

    public static void addToHashmap(TreeNode root, LinkedHashMap<List<Integer>, List<Integer>> hashMap, int i, int j){


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> position = Arrays.asList(i, j);

        if(hashMap.containsKey(position)){
            //add rootNode position and value to existing Hashmap
            hashMap.get(position).add(root.val);
            Collections.sort(hashMap.get(position));
        }
        else{
            //add rootNode position and value to Hashmap
            hashMap.put(position, new ArrayList<>(List.of(root.val)));
        }

        //add children to hashmap if exists
        if(root.left != null){
            addToHashmap(root.left, hashMap, i+1, j-1);
        }

        if(root.right != null){
            addToHashmap(root.right, hashMap, i+1, j+1);
        }
    }

    //merge nodes in the same column
    public static TreeMap<Integer, List<Integer>> mergeHashMap(LinkedHashMap<List<Integer>, List<Integer>> hashMap){

        TreeMap<Integer, List<Integer>> result = new TreeMap<>();

        //loop through keys and add matching column values into one list
        for(List<Integer> key : hashMap.keySet()){
            if(result.get(key.get(1))!=null) {

                result.get(key.get(1)).addAll(result.get(key).get(0), hashMap.get(key));
            }
            else{
                result.put(key.get(1), hashMap.get(key));
            }
        }

        return result;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(8, null, new TreeNode(3)), new TreeNode(1, new TreeNode(6, null, new TreeNode(4)), new TreeNode(2, new TreeNode(5, null, new TreeNode(7)), null)));
        System.out.println(verticalTraversal(root));
    }
}
