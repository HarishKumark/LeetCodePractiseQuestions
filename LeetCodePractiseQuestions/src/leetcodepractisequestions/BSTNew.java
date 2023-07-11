/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.LinkedList;
import java.util.Queue;
import javax.management.Query;

/**
 *
 * @author hkorada
 */
public class BSTNew {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ,");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ,");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ,");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println("");
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

        }
    }

    public static int countOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftNodes = sumOfNodes(root.left);
        int rightNodes = sumOfNodes(root.right);
        return leftNodes + rightNodes + root.data;
    }

    public static int heightOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftNodes = heightOfNodes(root.left);
        int rightNodes = heightOfNodes(root.right);
        return Math.max(leftNodes, rightNodes) + 1;
    }

    public static int diameterNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = diameterNodes(root.left);
        int rightNodes = diameterNodes(root.right);
        int leftHeight = heightOfNodes(root.left) + heightOfNodes(root.right) + 1;
        return Math.max(leftHeight, Math.max(leftNodes, rightNodes));
    }

    static class TreeInfo {

        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameterNodesAnotherApproach(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftNodes = diameterNodesAnotherApproach(root.left);
        TreeInfo rightNodes = diameterNodesAnotherApproach(root.right);
        int maxHeight = Math.max(leftNodes.ht, rightNodes.ht) + 1;

        int diam1 = leftNodes.diam;
        int diam2 = rightNodes.diam;
        int diam3 = leftNodes.ht + rightNodes.ht + 1;

        int mydiam = Math.max(diam3, Math.max(diam1, diam2));

        TreeInfo myInfo = new TreeInfo(maxHeight, mydiam);
        return myInfo;
    }

    public boolean isIdentitcal(Node root, Node subNode) {
        if (root == null && subNode == null) {
            return true;
        }

        if (root == null || subNode == null) {
            return false;
        }

        if (root.data == subNode.data) {
            return isIdentitcal(root.left, subNode.left) && isIdentitcal(root.right, subNode.right);
        }
        return false;
    }

    public boolean isSubTree(Node root, Node subNode) {
        if (subNode == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == subNode.data) {
            if (isIdentitcal(root, subNode)) {
                return true;
            }
        }
        return isIdentitcal(root.left, subNode) || isIdentitcal(root.right, subNode);

    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
//        System.out.println(root.data);

        System.out.println("==============Pre Order=======================");
        preOrder(root);
        System.out.println("");
        System.out.println("==============================================");

        System.out.println("==============In Order=======================");
        inOrder(root);
        System.out.println("");
        System.out.println("==============================================");

        System.out.println("==============Post Order=======================");
        postOrder(root);
        System.out.println("");
        System.out.println("==============================================");

        System.out.println("==============level Order=======================");
        levelOrder(root);
        System.out.println("");
        System.out.println("==============================================");

        System.out.println("==============Count Of nodes=======================");
        System.out.println(countOfNodes(root));
        System.out.println("==============================================");

        System.out.println("==============Sum Of nodes=======================");
        System.out.println(sumOfNodes(root));
        System.out.println("==============================================");

        System.out.println("==============Height Of nodes=======================");
        System.out.println(heightOfNodes(root));
        System.out.println("==============================================");

        System.out.println("==============diamete Of nodes=======================");
        System.out.println(diameterNodes(root));
        System.out.println("==============================================");

        System.out.println("==============diameter Second Approach=======================");
        System.out.println(diameterNodesAnotherApproach(root).diam);
        System.out.println("==============================================");

    }

}
