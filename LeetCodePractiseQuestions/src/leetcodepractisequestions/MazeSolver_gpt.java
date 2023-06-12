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

public class MazeSolver_gpt {

    public int shortestPathInMaze(int[][] maze, int startX, int startY, int targetX, int targetY) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];

            if (currX == targetX && currY == targetY) {
                // Reached the target, return the length of the shortest path
                return maze[currX][currY];
            }

            for (int[] dir : directions) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    maze[newX][newY] = maze[currX][currY] + 1; // Update the distance
                }
            }
        }

        return -1; // No clear path found
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 1, 0, 0},
            {0, 0, 0, 0}
        };

        MazeSolver_gpt solver = new MazeSolver_gpt();
        int shortestPath = solver.shortestPathInMaze(maze, 0, 0, 3, 3);
        System.out.println("Shortest path length: " + shortestPath);
    }
}
