//Problem Statement: Given the head of a linked list, remove the nth node from the end of the list and return its head.


import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Definition for singly-linked list.
class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

public class RemoveNthEndNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = reverse(head);

        int iterater = 1;

        ListNode curr = newHead;

        if(n==1){
            newHead=newHead.next;
        }
        else {
            //find nth last number
            while (iterater < n - 1) {
                curr=curr.next;
                iterater++;
            }

            curr.next=curr.next.next;
        }

        head = reverse(newHead);
        return head;
    }

    public static ListNode reverse(ListNode head){

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        //loop through and put next nodes into stack
        while(curr!=null){
            stack.add(curr);
            curr=curr.next;
        }

        if(stack.isEmpty()){
            return null;
        }

        curr = stack.pop();
        ListNode newHead = curr;

        //while stack not looped through
        while(!stack.isEmpty()){
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next=null;

        return newHead;
    }

    public static String printLL(ListNode head){

        StringBuilder string = new StringBuilder("[");

        while(head!=null){
            string.append(head.val);
            head=head.next;
        }

        string.append("]");

        return string.toString();
    }
    public static void main(String[] args) {
//        ListNode ll = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode ll = new ListNode(1);
        System.out.println(printLL(removeNthFromEnd(ll, 1)));
    }
}
