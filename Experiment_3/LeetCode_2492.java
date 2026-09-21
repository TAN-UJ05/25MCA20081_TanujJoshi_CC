class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            graph.get(u).add(new int[] { v, weight });
            graph.get(v).add(new int[] { u, weight });
        }
        boolean[] visited = new boolean[n + 1];
        return dfs(1, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int minScore = Integer.MAX_VALUE;
        for (int[] edge : graph.get(node)) {
            int next = edge[0];
            int weight = edge[1];
            minScore = Math.min(minScore, weight);
            if (!visited[next]) {
                minScore = Math.min(
                        minScore,
                        dfs(next, graph, visited));
            }
        }
        return minScore;
    }
}
