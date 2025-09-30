public class RevereseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("before ...");
        /*while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }*/

        ListNode reversedList = reverseLinklist(head);
        System.out.println("Reverse ..." );
        while (reversedList != null) {
            System.out.print(reversedList.value + " ");
            reversedList = reversedList.next;
        }
    }

    private static ListNode reverseLinklist(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current= nextNode;
        }
        return prev;

    }
}
