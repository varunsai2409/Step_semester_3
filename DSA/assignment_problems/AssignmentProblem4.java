import java.util.*;

public class AssignmentProblem4 {

    // Function to count scores in the band [low, high]
    public static int countInBand(int[] scores, int low, int high) {
        int leftIndex = firstGreaterOrEqual(scores, low);
        int rightIndex = firstGreater(scores, high);
        return rightIndex - leftIndex;
    }

    // Find first index with value >= target
    private static int firstGreaterOrEqual(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Find first index with value > target
    private static int firstGreater(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Example usage
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); // Expected: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected: 0
    }
}
