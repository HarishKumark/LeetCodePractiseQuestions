/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hkorada
 */
public class DepthOfBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<Integer> addList(TreeNode root, List<Integer> l) {
        if (root == null) {
            return l;
        }
        inorderTraversal(root.left);
        l.add(root.val);
        inorderTraversal(root.right);
        return l;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        return addList(root, l);
    }

    public TreeNode insertData(int data[]) {
        if (data == null) {
            return null;
        }
        return null;

    }

//    public int minDepth(TreeNode root) {
//
//    }
    public static void main(String[] args) {
        DepthOfBST dp = new DepthOfBST();

    }
}
