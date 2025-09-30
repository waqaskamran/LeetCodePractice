public class LinkedListQuestions {

    public static void main(String[] args) {

        ListNode linkedList = createLinkedList();
        System.out.println("has cycle" + hasCycle(linkedList));
    }

    public static ListNode createLinkedList() {

        ListNode listNode = new ListNode(1);
        ListNode listNod2 = new ListNode(2);
        ListNode listNod3 = new ListNode(3);
        ListNode listNod4 = new ListNode(4);
        ListNode listNod5 = new ListNode(5);

        listNode.next =listNod2;
        listNod2.next =listNod3;
        listNod3.next =listNod4;
        listNod4.next =listNod5;
        listNod5.next =listNod2;
        return listNode;
    }

    public static boolean hasCycle(ListNode node){

        if(node == null || node.next == null) return false;
        ListNode slow = node;
        ListNode fast = node;


        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow ==  fast){
                return true;
            }
        }

        return false;
    }


}



 class ListNode{
    ListNode next;
    int value;

    public ListNode(int value) {
        this.next = null;
        this.value = value;
    }
}
