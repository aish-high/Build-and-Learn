package Coding.LinkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.createPalindromeLinkedList();
        list.displayLinkedList(list.head);
        ListNode slow=list.head, fast=list.head;
        //Find middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //Reverse second half
        ListNode prev=null, temp;
        while(slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //Check palindrome
        ListNode left = list.head, right = prev;
        while(right != null){
            if(left.val != right.val) {
                System.out.println("Not Palindrome");
                break;
            }
            left = left.next;
            right = right.next;
        }
        System.out.println("is a palindrome");
    }
}
