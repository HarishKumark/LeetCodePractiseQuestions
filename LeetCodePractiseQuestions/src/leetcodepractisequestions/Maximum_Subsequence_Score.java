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
public class Maximum_Subsequence_Score {

    public static void main(String[] args) {
        long val = maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3);
        System.out.println("val " + val);

    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {

        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            triplets(l, i, k - i, nums1);

//            int val = nums1[k - i] + nums1[k - (i + 1)] + nums1[k - (i + 2)];
//            System.out.println(val);
        }
        return 0l;
    }

    public static void triplets(ArrayList<Integer> list, int start, int end, int[] nums1) {

        for (int i = start; i < end; i++) {
            list.add(nums1[i]);
        }

    }

}
