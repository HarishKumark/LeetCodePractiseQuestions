/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class CheckStraightLine {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
//        int[][] arr = {{0, 0}, {0, 1}, {0, -1}};
        System.out.println(arr.length);
        boolean b = checkStraightLine(arr);
        System.out.println(b);
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int x1, y1, x2, y2;
        x1 = coordinates[0][0];
        y1 = coordinates[0][1];
        x2 = coordinates[1][0];
        y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (((coordinates[i][1] - y1) * (x2 - x1)) != ((y2 - y1) * (coordinates[i][0] - x1))) {
                return false;
            }
        }
        return true;
    }
}
