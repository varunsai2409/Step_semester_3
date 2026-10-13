import java.util.*;

abstract class Room {
    protected int units;
    public Room(int units){ this.units = units; }
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units){ super(units); }
    public double calculateBill(){ return units * 8; }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants){ super(units); this.occupants = occupants; }
    public double calculateBill(){ return (units * 6.0) / occupants; }
}

class AcRoom extends Room {
    public AcRoom(int units){ super(units); }
    public double calculateBill(){ return units * 10 + 200; }
}

public class AssignmentProblem3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            if(type.equals("SHARED")){
                int units = Integer.parseInt(parts[1]);
                int occ = Integer.parseInt(parts[2]);
                Room r = new SharedRoom(units, occ);
                double bill = r.calculateBill();
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            } else {
                int units = Integer.parseInt(parts[1]);
                Room r = switch(type){
                    case "SINGLE" -> new SingleRoom(units);
                    default -> new AcRoom(units);
                };
                double bill = r.calculateBill();
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
