//Problem Statement: Given the head pointers of two linked lists
// where each linked list represents an integer number (each node is a digit),
// add them and return the resulting linked list.



//Time Complexity: O(max(n, m))
//Space Complexity: O(max(n, m))
public class AddingTwoIntegersLL {

    //Node class
    public static class Node{
        int val;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //add two linked lists
    public static Node add(Node l1, Node l2){

        Node result = new Node();
        Node head = result;
        int carry = 0;

        //while any values still to be added
        while(l1!=null || l2 != null){

            //acquire sum
            int sum = l1.val+l2.val+carry;

            //reset carry
            if(carry==1){
                carry = 0;
            }

            //double digits should carry to next sum
            if(sum>9){
                result.val = sum%10;
                carry = 1;
            }
            else{
                result.val = sum;
            }

            //iterate through
            l1=l1.next;
            l2=l2.next;

            //if a following node exists, continue
            if(l1!=null||l2!=null){
                result.next = new Node();
                result=result.next;

                //add 0 to nonexisting nodes
                if(l1==null){
                    l1= new Node(0);
                }
                if(l2==null){
                    l2= new Node(0);
                }

            }


        }

        //additional carry
        if(carry==1){
            result.next = new Node(1);
        }
        return head;
    }

    //printer
    public static void printLinkedList(Node head){

        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(0, new Node(9, new Node(9))));
        Node l2 = new Node(7, new Node(3, new Node(2)));
        printLinkedList(add(l1, l2));
    }
}
