import java.util.*;
public class ClassProblem3{
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f | %.2f | %.2f | %s%n", i+1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            heights[i] = 1.5 + rand.nextDouble() * 0.5; // 1.5m to 2.0m
            weights[i] = 50 + rand.nextDouble() * 50;   // 50kg to 100kg
        }

        printWellnessReport(heights, weights);
    }
}
