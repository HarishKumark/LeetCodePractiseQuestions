/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import static leetcodepractisequestions.Minimum_Absolute_Difference_in_BST.BinaryTree.buildTree;

/**
 *
 * @author hkorada
 */
public class Minimum_Absolute_Difference_in_BST {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static TreeNode buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            TreeNode n = new TreeNode(nodes[idx]);
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }

        public static void preOrder(TreeNode root) {
            if (root == null) {
                System.out.println("-1");
                return;
            }
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void InOrder(TreeNode root) {
            if (root == null) {
                System.out.println("-1");
                return;
            }
            InOrder(root.left);
            System.out.println(root.val);
            InOrder(root.right);
        }

        public static void postOrder(TreeNode root) {
            if (root == null) {
//                System.out.println("-1");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }

        public static int addNodeData(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return addNodeData(root.left) + addNodeData(root.right) + root.val;
        }
    }

//    public int getMinimumDifference(TreeNode root) {
//
//    }
    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        TreeNode n = buildTree(nodes);
        System.out.println("n=== " + n.val);
        BinaryTree.preOrder(n);
        BinaryTree.postOrder(n);
        System.out.println(BinaryTree.addNodeData(n));
    }

}
