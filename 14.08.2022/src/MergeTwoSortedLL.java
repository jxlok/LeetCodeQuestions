public class MergeTwoSortedLL {

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

    public static Node mergeTwoSortedLL(Node l1, Node l2){

        Node result = new Node();
        Node head = result;

        while(l1!=null||l2!=null){

            //if l1 is empty, continue with l2
            if(l1==null){
                //set value
                result.val = l2.val;
                //iterate
                l2=l2.next;
                if(l2!=null){
                    result.next = new Node();
                    result = result.next;
                }
                continue;
            }
            else if(l2==null){
                //set value
                result.val= l1.val;
                //iterate
                l1=l1.next;
                if(l1!=null){
                    result.next = new Node();
                    result = result.next;
                }
                continue;
            }

            if(l1.val<=l2.val){
                //set value
                result.val= l1.val;
                //iterate
                l1=l1.next;
            }
            else{
                //set value
                result.val = l2.val;
                //iterate
                l2=l2.next;
            }

            result.next = new Node();
            result = result.next;


        }

        return head;
    }

    //printer
    public static void printLinkedList(Node head){

        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(2, new Node(4)));
        Node l2 = new Node(3, new Node(5, new Node(6)));
        printLinkedList(mergeTwoSortedLL(l1, l2));
    }
}
