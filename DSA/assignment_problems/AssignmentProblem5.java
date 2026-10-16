public class AssignmentProblem5 {

    // Function to find the second-highest distinct score
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                // Update both highest and second
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                // Update second only if it's distinct and greater
                second = score;
            }
        }

        return second;
    }

    // Example usage
    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        int[] scores2 = {50, 50, 50};

        System.out.println(secondHighest(scores1)); // Expected: 78
        System.out.println(secondHighest(scores2)); // Expected: -1
    }
}
