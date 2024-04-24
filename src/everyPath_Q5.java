import java.util.ArrayList;
import java.util.List;

public class everyPath_Q5 {
    private static int[][] graph; // Adjacency matrix representing the directed graph
    private static int n; // Number of vertices
    private static List<String> vertices;
    private static List<List<Integer>> paths;

    private static void dfs(int u, int w, int length, List<Integer> path) {
        if (length == 0 && u == w) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int v = 0; v < n; v++) {
            if (graph[u][v] == 1 && !path.contains(v)) {
                path.add(v);
                dfs(v, w, length - 1, path);
                path.remove(path.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
        // Example directed graph represented as an adjacency matrix
//        graph = new int[][] {
//                {1, 1, 1, 0, 0, 0},
//                {0, 1, 0, 1, 0, 1},
//                {0, 0, 1, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0, 1}
//        };

        graph = new int[][] {
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        n = graph.length;

        vertices = new ArrayList<>();
        paths = new ArrayList<>();

        // Initialize vertices
        for (int i = 0; i < n; i++) {
            vertices.add(String.valueOf(i));
        }

        int u = 0; // Source vertex
        int w = 5; // Destination vertex

        List<Integer> path = new ArrayList<>();
        path.add(u);
        dfs(u, w, 5, path);

        if (paths.isEmpty()) {
            System.out.println("No simple paths found from " + u + " to " + w + " with length 5.");
        } else {
            System.out.println("Simple paths found:");
            for (List<Integer> p : paths) {
                System.out.println(p);
            }
        }
    }



}
