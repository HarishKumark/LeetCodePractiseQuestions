/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hkorada
 */
public class Sqrt {

    public static void main(String[] args) {
//        int res = mySqrt(1);
//        System.out.println(res);

        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        merge(new int[]{1}, 1, new int[]{}, 0);
    }

    public static int mySqrt(int number) {
        if (number <= 1) {
            return number;
        }
        double temp;

        double sr = number / 2;

        do {
            temp = sr;
            sr = (temp + (number / temp)) / 2;
        } while ((temp - sr) != 0);

        return (int) sr;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(ArrayList::new));
        l1 = l1.subList(0, m);
        List<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(ArrayList::new));
        l2 = l2.subList(0, n);
        l1.addAll(l2);
        Collections.sort(l1);
//        System.out.println(l1);
//        nums1 = null;
//        nums1 = new int[m + n];
        for (int i = 0; i < l1.size(); i++) {
            nums1[i] = l1.get(i);
        }
        
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i]);
//        }

    }
}
