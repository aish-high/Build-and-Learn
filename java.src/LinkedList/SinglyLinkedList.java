package LinkedList;

public class SinglyLinkedList {
    ListNode head;

    public void addLinkedListNode(int value){
        ListNode newNode = new ListNode(value);
        if(head==null){
            head = newNode;
        } else {
            ListNode curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
    }

    public void createPalindromeLinkedList(){
        for(int i = 1; i<=2; i++){
            addLinkedListNode(i);
        }
        for (int i = 2; i >= 1 ; i--) {
            addLinkedListNode(i);
        }
    }

    public void createLinkedList(){
        for(int i = 1; i<=5; i++){
            addLinkedListNode(i);
        }
    }

    public void displayLinkedList(ListNode head){
        if (head == null)
            System.out.println("Linked List is empty");
        else {
            ListNode curr = head;
            while(curr != null){
                System.out.print(curr.val);
                curr = curr.next;
            }
            System.out.println();
        }
    }
}
