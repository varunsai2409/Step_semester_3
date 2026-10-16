import java.util.Scanner;

public class ClassProblem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0, reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}
