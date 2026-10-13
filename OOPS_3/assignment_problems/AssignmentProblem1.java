import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount - (amount * 0.10); // 10% discount
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount - (amount * 0.05); // 5% discount
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10; // ₹10 service charge
    }
}

public class Assignmentproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                case "GUEST":
                    customer = new Guest(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }

            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
