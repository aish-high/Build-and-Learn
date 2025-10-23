package LinkedList;

public class ReverseLinkedList {

    static SinglyLinkedList list = new SinglyLinkedList();

    public static void main(String[] args) {
        list.createLinkedList();
        list.displayLinkedList(list.head);
        ListNode prev=null, curr=list.head, temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        System.out.println("Reversed list:");
        list.displayLinkedList(prev);
    }
}
