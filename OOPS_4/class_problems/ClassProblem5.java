import java.util.*;

abstract class Booking {
    int distance;
    static final double BOOKING_FEE=50; // one place only
    Booking(int distance){ this.distance=distance; }
    abstract double baseFare();
    double totalFare(){ return baseFare()+BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(int distance){ super(distance); }
    double baseFare(){ return distance*2; }
}

class TrainBooking extends Booking {
    TrainBooking(int distance){ super(distance); }
    double baseFare(){ return distance*1.5; }
}

class FlightBooking extends Booking {
    FlightBooking(int distance){ super(distance); }
    double baseFare(){ return 2500 + distance*4; }
}

public class ClassProblem5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Booking> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String mode=sc.next();
            int dist=sc.nextInt();
            switch(mode){
                case "BUS": list.add(new BusBooking(dist)); break;
                case "TRAIN": list.add(new TrainBooking(dist)); break;
                case "FLIGHT": list.add(new FlightBooking(dist)); break;
            }
        }
        double total=0;
        for(Booking b:list){
            double fare=b.totalFare();
            System.out.printf("%s: %.2f%n", b.getClass().getSimpleName().replace("Booking","").toUpperCase(), fare);
            total+=fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
