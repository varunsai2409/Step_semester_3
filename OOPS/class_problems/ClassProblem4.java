import java.util.Arrays;

public class ClassProblem4 {

    // Helper method to compute average of a row
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    // Main method to classify rows
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            if (avg < threshold) {
                result.append("Row ").append(i).append(": Quiet Zone");
            } else {
                result.append("Row ").append(i).append(": Buzzing Zone");
            }
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String output = classifyRows(seatingScores, threshold);
        System.out.println(output);
    }
}
