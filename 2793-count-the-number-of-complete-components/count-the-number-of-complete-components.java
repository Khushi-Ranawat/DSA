class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
         boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int completeCount = 0;

        // DFS traversal
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, list, visited, component);

                
                int edgeCount = 0;
                for (int node : component) {
                    edgeCount += list.get(node).size();
                }
                edgeCount /= 2; 

                
                int vertexCount = component.size();
                int expectedEdges = (vertexCount * (vertexCount - 1)) / 2;
                if (edgeCount == expectedEdges) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }

    private void dfs(int node, List<List<Integer>> list, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, list, visited, component);
            }
        }
    }
}