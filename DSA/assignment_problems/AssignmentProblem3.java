import java.util.*;

public class AssignmentProblem3{

    // Function to rotate roster k places to the right
    public static List<String> rotateRoster(List<String> names, int k) {
        int n = names.size();
        if (n == 0) return names;

        // Reduce k to within bounds using modulo
        k = k % n;

        // Create new list for rotated result
        List<String> rotated = new ArrayList<>();

        // Add last k elements first
        for (int i = n - k; i < n; i++) {
            rotated.add(names.get(i));
        }

        // Add the remaining elements
        for (int i = 0; i < n - k; i++) {
            rotated.add(names.get(i));
        }

        return rotated;
    }

    // Example usage
    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("A", "B", "C", "D", "E");
        System.out.println(rotateRoster(names1, 2)); // Expected: [D, E, A, B, C]

        List<String> names2 = Arrays.asList("A", "B", "C", "D", "E");
        System.out.println(rotateRoster(names2, 7)); // Expected: [D, E, A, B, C]
    }
}
