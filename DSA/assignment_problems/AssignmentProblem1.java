public class AssignmentProblem1 {

    // Function to find the busiest row
    public static String busiestRow(int[][] grid) {
        int maxTotal = -1;
        int busiestIndex = -1;

        // Outer loop for rows
        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;

            // Inner loop for columns
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
            }

            // Update if strictly larger
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                busiestIndex = i;
            }
        }

        return "Row " + busiestIndex + ", Total " + maxTotal;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println(busiestRow(grid));
    }
}
