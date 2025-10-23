package LinkedList;

public class LinkedListCycle {
    static SinglyLinkedList list = new SinglyLinkedList();

    public static void main(String[] args) {
        list.createLinkedList();
        list.displayLinkedList(list.head);
        ListNode fast = list.head, slow = list.head;
        while(fast!=null && fast.next != null){
            fast =  fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                System.out.println("Cycle found");
                break;
            }
        }
    }
}
