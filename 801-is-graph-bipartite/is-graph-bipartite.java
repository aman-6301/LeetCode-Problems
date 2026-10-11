class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.length; i++) {

            if (color[i] != -1) {
                continue;
            }

            color[i] = 0;
            queue.offer(i);

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : graph[node]) {

                    if (color[neighbor] == -1) {

                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);

                    } else if (
                            color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}

