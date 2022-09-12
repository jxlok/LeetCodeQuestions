//Problem Statement: You are given a linked list where the node has two pointers. The first is the regular next pointer.
// The second pointer is called arbitrary_pointer and it can point to any node in the linked list.
//
//Here, deep copy means that any operations on the original list (inserting, modifying, and removing) should not affect the copied list.
//
//Here’s an example of a linked list with arbitrary pointers connected.

//Time complexity: O(n^2)
//Space Complexity: O(n)
public class CopyLinkedList {

    //Node class
    public static class Node{

        int val;
        Node next;
        Node arbitrary_pointer;

        public Node(int val, Node next, Node arbitrary_pointer) {
            this.val = val;
            this.next = next;
            this.arbitrary_pointer = arbitrary_pointer;
        }

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    //copy function
    public static Node copyLinkedList(Node l1){

        Node newList = new Node();
        Node head = newList;
        Node iterator = l1;

        //loop to copy the value and next pointer
        while(iterator != null){
            //copy value
            newList.val = iterator.val;
            if(iterator.next!=null) {
                newList.next = new Node();
            }

            newList = newList.next;
            iterator = iterator.next;
        }


        Node arbitrary_iterator = head;
        //loop through and complete arbitrary pointer
        while(l1!= null){
            Node search = head;
            //search through and set arbitrary pointer
            while(search != null && l1.arbitrary_pointer!=null){
                if(search.val == l1.arbitrary_pointer.val){
                    arbitrary_iterator.arbitrary_pointer = search;
                    break;
                }
                search = search.next;
            }
            l1=l1.next;
            arbitrary_iterator = arbitrary_iterator.next;
        }

        return head;
    }

    //printer
    public static void printLinkedList(Node head){

        Node iterator = head;

        while(iterator!=null){
            System.out.print(iterator.val+" ");
            iterator=iterator.next;
        }

        System.out.println();
        iterator = head;

        while(iterator!=null){
            if(iterator.arbitrary_pointer == null){
                System.out.println(iterator.val+"->NULL");

            }
            else {
                System.out.println(iterator.val + "->" + iterator.arbitrary_pointer.val);
            }
            iterator=iterator.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(7);
        Node l2 = new Node(14);
        Node l3 = new Node(21);

        l1.next = l2;
        l1.arbitrary_pointer = l3;

        l2.next = l3;

        l3.arbitrary_pointer = l1;

        Node copy1 = copyLinkedList(l1);

        //change original
        l2.arbitrary_pointer = l1;

        Node copy2 = copyLinkedList(l1);

        //different copies (deep copied complete)
        printLinkedList(copy1);
        printLinkedList(copy2);

    }
}
