/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    private static final int[][] DIRECTIONS = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        distances[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            if (currX == n - 1 && currY == n - 1) {
                return distances[currX][currY];
            }

            for (int[] dir : DIRECTIONS) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0
                        && distances[nextX][nextY] > distances[currX][currY] + 1) {
                    distances[nextX][nextY] = distances[currX][currY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        int shortestPathLength = shortestPathBinaryMatrix(grid);
        System.out.println("Shortest path length: " + shortestPathLength);
    }
}

