//Problem Statement: Given an n-ary tree, return the level order traversal of its nodes' values.
//
//Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See examples)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//Time Complexity: O(n)
//Space Complexiy: O(n^2)
public class LevelOrderTraversal {



    public List<List<Integer>> levelOrder(Node root) {

        //Edge case: empty input
        if(root == null){
            return new ArrayList<>();
        }

        //queue data structure to traverse different levels
        Queue<Node>  queue = new LinkedList<>();

        //add root to queue initially
        queue.add(root);

        //resulting list
        List<List<Integer>> result = new ArrayList<>();

        //Add nodes at each level and continue until all nodes exerted through
        while(!queue.isEmpty()){

            int numInLevel = queue.size();

            List<Integer> level = new ArrayList<>();

            //while nodes in level not dealt with
            while(numInLevel>0){

                //take from queue
                Node curr = queue.poll();

                //add node to the level's list
                assert curr != null;
                level.add(curr.val);

                //add children to queue
                queue.addAll(curr.children);
                numInLevel--;
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}


