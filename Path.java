package algo;

import java.util.*;
public class Path {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        int start = scanner.nextInt() - 1;
        int end = scanner.nextInt() - 1;
        if (start == end) {
            System.out.println(0);
            return;
        }
        int shortestPathLength = bfs(adjacencyMatrix, start, end, n);
        System.out.println(shortestPathLength);
    }
    private static int bfs(int[][] graph, int start, int end, int n) {
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0];
            int distance = current[1];
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[vertex][neighbor] == 1 && !visited[neighbor]) {
                    if (neighbor == end) {
                        return distance + 1;
                    }
                    queue.add(new int[]{neighbor, distance + 1});
                    visited[neighbor] = true;
                }
            }
        }
        return -1;
    }

}

