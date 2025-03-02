package com.rajakash.interview.graphs.templates;

public class RecursiveDfs1D {
    //caller function
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        //declare visited array
        boolean[] visited = new boolean[cities];
        int result = 0;
        //iterate through all needs
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                result++;
                //recursion start
                // pass current node , graph , visited array
                 dfs(i, isConnected, visited, cities);
            }
        }
        return result;
    }

        public void dfs(int node, int[][] graph, boolean[] visit, int n) {
        //mark current node visited
        visit[node] = true;
        for (int i = 0; i < n; i++) {
            //if all connected neighbors marked visited do nothing , else mark visit and call Dfs recursively
            if (graph[node][i] == 1 && !visit[i]) {
                dfs(i, graph, visit, n);
            }
        }
    }
}
