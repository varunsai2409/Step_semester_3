import java.util.*;

abstract class Transport {
    protected double distance;
    public Transport(double d){ distance=d; }
    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double d){ super(d); }
    public double calculateFare(){
        double fare = 2 + 0.1*distance;
        return Math.min(fare,10);
    }
}

class Train extends Transport {
    public Train(double d){ super(d); }
    public double calculateFare(){ return 3 + 0.15*distance; }
}

class Metro extends Transport {
    private double peakFactor;
    public Metro(double d,double pf){ super(d); peakFactor=pf; }
    public double calculateFare(){ return (1.5 + 0.2*distance)*peakFactor; }
}

public class ClassProblem5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total=0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            Transport t=null;
            if(type.equals("BUS")) t = new Bus(Double.parseDouble(parts[1]));
            else if(type.equals("TRAIN")) t = new Train(Double.parseDouble(parts[1]));
            else if(type.equals("METRO")) t = new Metro(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]));
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", type, fare);
            total+=fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
