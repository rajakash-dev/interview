package com.rajakash.interview.graphs.problems;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result = Math.max(dfs(i, j, grid, visited, m, n), result);
                }
            }
        }
        return result;
    }

    public static int dfs(int i, int j, int[][] grid, boolean[][] visited, int m, int n) {
        // U , D , L , R
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        for (int x = 0; x < 4; x++) {
            // if not island
            // is out of bounds
            int newX = i + dx[x];
            int newY = j + dy[x];
            count += dfs(newX, newY, grid, visited, m, n);
        }
        return count;
    }
}
