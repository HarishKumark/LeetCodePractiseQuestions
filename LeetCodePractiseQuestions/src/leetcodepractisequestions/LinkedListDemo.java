/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.Stack;

/**
 *
 * @author hkorada
 */
public class LinkedListDemo {

    static class ListNode {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0, carry = 0;

        ListNode n = new ListNode();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            System.out.println("sum == " + sum);
            n.val = sum % 10;
            carry = sum / 10;
            System.out.println("carry "+ carry);
            ListNode head = new ListNode(carry);
            head.next = n;
            n = head;
            sum = carry;
        }
        return carry == 0 ? n.next : n;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l = addTwoNumbers(l1, l2);

        while (l != null) {
            System.out.println("val == " + l.val);
            l = l.next;
        }
    }

}
