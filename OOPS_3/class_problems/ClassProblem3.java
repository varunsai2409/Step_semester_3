import java.util.*;

abstract class Delivery {
    protected double weight, distance;
    public Delivery(double w, double d){ weight=w; distance=d; }
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double w,double d){ super(w,d); }
    public double calculateFee(){ return 5 + 0.5*weight + 0.1*distance; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double w,double d){ super(w,d); }
    public double calculateFee(){ return 15 + 1.0*weight + 0.2*distance; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    public InternationalDelivery(double w,double d,double c){ super(w,d); customsFee=c; }
    public double calculateFee(){ return 25 + 2.0*weight + 0.5*distance + customsFee; }
}

public class ClassProblem3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total=0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            Delivery d = null;
            if(type.equals("STANDARD")) d = new StandardDelivery(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]));
            else if(type.equals("EXPRESS")) d = new ExpressDelivery(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]));
            else if(type.equals("INTERNATIONAL")) d = new InternationalDelivery(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]),Double.parseDouble(parts[3]));
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total+=fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
