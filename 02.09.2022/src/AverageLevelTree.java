import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AverageLevelTree {
    
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
    
    public static List<Double> averageOfLevels(TreeNode root) {

        //queue to keep track at each level for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        //add root to queue
        queue.add(root);

        List<Double> result = new LinkedList<>();

        //loop through until queue is completely empty
        while(!queue.isEmpty()){

            double sum=0;

            //number of nodes on this level
            int nodesOnLayer=queue.size();
            int i = nodesOnLayer;

            //while current level not dealt with
            while(i>0){

                TreeNode node = queue.poll();

                //add children to queue (next layer)
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                //keep sum
                sum += node.val;
                i--;
            }

            //add avg of layer to answer
            Double average = sum / (double) nodesOnLayer;
            result.add(average);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(averageOfLevels(root));
    }
}
