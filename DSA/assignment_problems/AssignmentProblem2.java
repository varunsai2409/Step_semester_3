public class AssignmentProblem2 {

    // Function to compute attendance summary
    public static String attendanceSummary(int[] days) {
        int presentCount = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        // Single pass through the array
        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0; // reset streak on absence
            }
        }

        return "Present: " + presentCount + ", Longest streak: " + longestStreak;
    }

    // Example usage
    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] days2 = {0, 0, 0};

        System.out.println(attendanceSummary(days1)); // Expected: Present: 6, Longest streak: 3
        System.out.println(attendanceSummary(days2)); // Expected: Present: 0, Longest streak: 0
    }
}
