class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    String assignGrade(double avg) {
        if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    void printResult() {
        double avg = calculateAverage();
        System.out.printf("%s: Average %.1f, Grade %s%n", name.toUpperCase(), avg, assignGrade(avg));
    }
}

public class ClassProblem10 {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        s1.printResult();
        s2.printResult();
    }
}
