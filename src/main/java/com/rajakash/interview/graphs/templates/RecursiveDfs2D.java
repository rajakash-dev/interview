package com.rajakash.interview.graphs.templates;

/**
 * In this implementation a 2D arrray has 0 ot 1
 */
public class RecursiveDfs2D {
    public static int numIslands(char[][] grid) {
        // find row and col length
        int m = grid.length;
        int n = grid[0].length;
        //define visited
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        // go through each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //check for visited and any other condition if needed on current node
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    // call DFS on current node
                    dfs(i, j, grid, visited, m, n);
                }
            }
        }
        return result;
    }

    public static void dfs(int i, int j, char[][] grid, boolean[][] visited, int m, int n) {
        // U , D , L , R - all directions
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};
        //check if the indexes you got are in the grid and that the current node is not visited
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] != '1' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int x = 0; x < 4; x++) {
            // if not island
            // is out of bounds
            int newX = i + dx[x];
            int newY = j + dy[x];
            dfs(newX, newY, grid, visited, m, n);
        }

    }
}
