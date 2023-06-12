/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class largestRectangleArea_84 {

    public static void main(String[] args) {
//        int max = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});//ans 10
//        int max = largestRectangleArea(new int[]{2, 4}); // ans 4
//        int max = largestRectangleArea(new int[]{2, 1, 2}); // ans 3
//        int max = largestRectangleArea(new int[]{1, 2, 2}); // ans 4
        int max = largestRectangleArea(new int[]{4,2,3}); // ans 6

        System.out.println("max == " + max);
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length <= 1) {
            return heights[0];
        }
        int[] hh = new int[heights.length];
        int temp = 0;

        int remainingVal = 0;
        if (heights.length % 2 != 0) {
            remainingVal = heights[heights.length - 1];
        }
        int diff = 0;
        for (int i = heights.length - 1; i > 0; i -= 2) {

            if (heights[i] == 0) {
                diff = heights[i];
            } else if (heights[i - 1] == 0) {
                diff = heights[i - 1];
            } else {
                if (heights[i] > heights[i - 1]) {
                    diff = heights[i] - heights[i - 1];
                } else {
                    diff = heights[i - 1] - heights[i];
                }
            }
            hh[temp++] = (heights[i] + heights[i - 1]) - diff;
        }
        int max = remainingVal + diff;
        for (int i = 0; i < hh.length; i++) {
            if (hh[i] >= max) {
                max = hh[i];
            }
        }
        return max;
    }
}
