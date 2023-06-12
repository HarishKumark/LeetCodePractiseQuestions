/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author hkorada
 */
public class Plus_one {

    public static void main(String[] args) {

        int[] index = plusOne(new int[]{4, 3, 2, 1});
//        int[] index = plusOne(new int[]{9});
//        int[] index = plusOne(new int[]{1, 2, 3});
//        int[] index = plusOne(new int[]{9, 9});

        for (int i : index) {
            System.out.print(i + ", ");
        }

    }

    public static int[] plusOne(int[] digits) {

        if (digits.length == 0) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] n = new int[digits.length + 1];
        n[0] = 1;
        return n;
    }

}
