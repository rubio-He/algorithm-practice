import java.util.List;

public class Reverse_LinkedList {


    public ListNode iterative(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }




    public ListNode recursive(ListNode head){
        return helper(head, null);
    }
    private ListNode helper(ListNode head, ListNode newHead){
        if(head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return helper(next, head);
    }
}
class ListNode{
    String val;
    ListNode next;
    public ListNode(String val){
        this.val = val;
    }
}