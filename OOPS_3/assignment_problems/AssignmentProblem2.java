import java.util.*;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours){ this.hours = hours; }
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours){ super(hours); }
    public double calculateCharge(){ return hours * 10; }
}

class Car extends Vehicle {
    public Car(int hours){ super(hours); }
    public double calculateCharge(){ return 30 + (hours-1)*20; }
}

class Truck extends Vehicle {
    public Truck(int hours){ super(hours); }
    public double calculateCharge(){ return Math.max(100, hours*50); }
}

public class AssignmentProblem2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int hrs = Integer.parseInt(parts[1]);
            Vehicle v = switch(type){
                case "BIKE" -> new Bike(hrs);
                case "CAR" -> new Car(hrs);
                default -> new Truck(hrs);
            };
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
