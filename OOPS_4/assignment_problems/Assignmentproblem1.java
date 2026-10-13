import java.util.*;

abstract class Ticket {
    int count;
    static final double FEE = 20; // one place only
    Ticket(int count){ this.count = count; }
    abstract double basePrice();
    double totalAmount(){ return count * (basePrice() + FEE); }
}

class RegularTicket extends Ticket {
    RegularTicket(int count){ super(count); }
    double basePrice(){ return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count){ super(count); }
    double basePrice(){ return 250; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count){ super(count); }
    double basePrice(){ return 400; }
}

public class AssignmentProblem1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();
        List<String> types = new ArrayList<>();
        for(int i=0;i<n;i++){
            String type = sc.next();
            int count = sc.nextInt();
            switch(type){
                case "REGULAR": tickets.add(new RegularTicket(count)); break;
                case "PREMIUM": tickets.add(new PremiumTicket(count)); break;
                case "RECLINER": tickets.add(new ReclinerTicket(count)); break;
            }
            types.add(type);
        }
        double total=0;
        for(int i=0;i<n;i++){
            double amt = tickets.get(i).totalAmount();
            System.out.printf("%s: %.2f%n", types.get(i), amt);
            total+=amt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
