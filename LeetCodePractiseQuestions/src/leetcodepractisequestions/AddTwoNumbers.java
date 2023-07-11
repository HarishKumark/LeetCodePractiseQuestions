/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class AddTwoNumbers {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;

        int carry = 0;
        while (currentNode1 != null || currentNode2 != null) {
            int sum = 0;
            if (currentNode1 != null) {
                sum += currentNode1.val;
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                sum += currentNode2.val;
                currentNode2 = currentNode2.next;
            }
            int data = carry + sum;
            carry = (data / 10);
            addNode(data % 10);
        }
        addNode(carry);

        return head;
    }

    public void addNode(int data) {
        ListNode n = new ListNode(data);
        if (head == null) {
            head = n;
            return;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = n;

    }

    public static void main(String[] args) {

//        System.out.println("" + (18 % 10));
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l3 = a.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}
