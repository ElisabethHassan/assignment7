import java.util.ArrayList;
import java.util.List;

public class everyPath_Q5 {
    private static int[][] graph; // the directed weighted graph
    private static int n;  // num of vertices

    private static void findPaths(int u, int w, int length, List<Integer> path) {
        //base case
        if (length == 0) {
            if (u == w) {
                System.out.println("Simple path found: " + path);
            }
            return;
        }

        for (int v = 0; v < n; v++) {
            if (graph[u][v] == 1) {
                if (!path.contains(v)) {
                    path.add(v);
                    findPaths(v, w, length - 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example directed weighted graph represented as an adjacency matrix
        graph = new int[][] {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        n = graph.length;

        int u = 0; // Source vertex
        int w = 5; // Destination vertex

        List<Integer> path = new ArrayList<>();
        path.add(u);

        findPaths(u, w, 5, path);

        if (path.isEmpty()) {
            System.out.println("No simple paths found from " + u + " to " + w + " with length 5.");
        }
    }


}
