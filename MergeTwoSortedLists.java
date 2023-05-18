public class MergeTwoSortedLists {

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        MergeTwoSortedLists mm = new MergeTwoSortedLists();
        ListNode newNode = mm.mergeTwoLists(list1, list2);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;

        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = null;
        while (list1 != null) {
            newNode = new ListNode(list2.val, new ListNode(list1.val));
            while (newNode != null) {
                newNode.next = new ListNode(list2.val, new ListNode(list1.val));
            }

            list1 = list1.next;
            list2 = list2.next;
        }
        return newNode;
    }

}
