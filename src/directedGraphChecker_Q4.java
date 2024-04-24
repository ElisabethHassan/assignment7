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
        // Check if the matrix is square -> if not false
        if (matrix.length != matrix[0].length) {
            return false;
        }

        // check for symmetry -> if the entire graph is symmetry it indicates no direction
        int j;
        for (int i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }


        return true;
    }

}
