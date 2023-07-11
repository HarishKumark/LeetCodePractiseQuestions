/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class BSTSearch {

    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public int isFound(Node root, int target, int count) {
        if (root == null) {
            return -1;
        }
        if (root.data > target) {
            return isFound(root.left, target, (count + 1));
        } else if (root.data == target) {
            return count;
        } else {
            return isFound(root.right, target, (count + 1));
        }
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " -> ");
        preOrder(root.right);
    }

    public Node insertData(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insertData(root.left, val);
        } else {
            root.right = insertData(root.right, val);
        }
        return root;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            root = insertData(root, num);
        }
//        preOrder(root);
        int count = 0;
        count = isFound(root, target, count);
//        System.out.println("count " + count);
        return count;
    }

    public int searchNew(int[] nums, int target) {

        int end = nums.length;
        int st = 0;
        while (st < end) {
            int mid = (st + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BSTSearch b = new BSTSearch();
//        int index = b.searchNew(nums, target);
        String str = "abcd";
        b.reverseString(str.length()-1, str);
        System.out.println("");
//        System.out.println(index);
//        System.out.println(index);
//        b.inOrder(root);

    }

    public void reverseString(int idx, String str) {
        if(idx == 0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        reverseString(--idx, str);

    }
}
