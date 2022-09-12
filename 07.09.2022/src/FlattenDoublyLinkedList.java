//Problem Statement:You are given a doubly linked list,
// which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
// This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
// These child lists may have one or more children of their own, and so on, to produce a multilevel data structure
// as shown in the example below.
//
//Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
// doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and
// before curr.next in the flattened list.
//
//Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class FlattenDoublyLinkedList {

    public static Node flatten(Node head) {

        //iterator
        Node curr = head;

        //iterate through linked list and find a case where a child is not null
        while(curr!=null){

            //if child exists
            if(curr.child!=null){

                //record the next node
                Node temp = curr.next;

                //connect next node and child
                curr.next = curr.child;
                curr.next.prev = curr;

                //traverse to end of child
                Node childTraverser = curr.child;
                while(childTraverser.next!=null){
                    childTraverser = childTraverser.next;
                }

                //connect end of child to original next node
                if(temp!=null) {
                    childTraverser.next = temp;
                    temp.prev = childTraverser;
                }

                //set child to null
                curr.child = null;
            }

            //iterate through
            curr=curr.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
