/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.ArrayList;

/**
 *
 * @author hkorada
 */
public class BinarySearchTree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            //left
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            //left
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static Node deleteNode(Node root, int val) {

        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node io = inOrderSuccessor(root.right);
            root.data = io.data;
            root.right = deleteNode(root.right, io.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void printRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printRange(root.left, x, y);
            System.out.print(root.data + " ");
            printRange(root.right, x, y);
        } else if (root.data >= y) {
            printRange(root.left, x, y);
        } else {
            printRange(root.right, x, y);
        }
    }

    private static void printPath(ArrayList<Integer> path) {
        for (Integer integer : path) {
            System.out.print(integer + "->");
        }
        System.out.println("");
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);

        System.out.println("");
        printRange(root, 3, 7);

        System.out.println("");

        rootToLeaf(root, new ArrayList<>());
        System.out.println("");
//        deleteNode(root, 8);
//        inOrder(root);
        System.out.println("search " + search(root, 8));
    }

}
