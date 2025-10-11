package Coding.LinkedList;

public class RemoveNthNodeFromEndOfList {
    static SinglyLinkedList list = new SinglyLinkedList();
    public static void main(String[] args) {
        list.createLinkedList();
        list.displayLinkedList(list.head);
        ListNode fast = list.head, slow = list.head;
        int i = 0, n=2;
        while(i < n){
            fast = fast.next;
            i++;
        }
        if(fast == null)
            System.out.println("Head: " + list.head.next);
        else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        System.out.print("Head: " );
        list.displayLinkedList(list.head);
    }
}
