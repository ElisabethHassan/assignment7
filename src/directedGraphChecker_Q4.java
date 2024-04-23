import java.util.Scanner;

public class directedGraphChecker_Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (isDirectedGraph(matrix, n)) {
            System.out.println("The given matrix represents a directed graph.");
        } else {
            System.out.println("The given matrix does not represent a directed graph.");
        }

        scanner.close();
    }

    public static boolean isDirectedGraph(int[][] matrix, int n) {
        // Check if the matrix is square
        if (matrix.length != matrix[0].length) {
            return false;
        }

        // Check for loops
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] != 0) {
                return false;
            }
        }

        // Check for symmetry
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        // Check for multiple edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
