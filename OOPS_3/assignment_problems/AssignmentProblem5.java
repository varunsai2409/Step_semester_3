import java.util.*;
import java.time.*;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;
    public Plan(String name, LocalDate startDate){ this.name = name; this.startDate = startDate; }
    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends Plan {
    public BasicPlan(String name, LocalDate startDate){ super(name, startDate); }
    public LocalDate getRenewalDate(){ return startDate.plusDays(30); }
}

class StandardPlan extends Plan {
    public StandardPlan(String name, LocalDate startDate){ super(name, startDate); }
    public LocalDate getRenewalDate(){ return startDate.plusDays(90); }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String name, LocalDate startDate){ super(name, startDate); }
    public LocalDate getRenewalDate(){ return startDate.plusDays(365); }
}

public class AssignmentProblem5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            LocalDate start = LocalDate.parse(parts[2]);
            Plan p = switch(type){
                case "BASIC" -> new BasicPlan(name, start);
                case "STANDARD" -> new StandardPlan(name, start);
                default -> new PremiumPlan(name, start);
            };
            LocalDate renewal = p.getRenewalDate();
            System.out.printf("%s: %s%n", name, renewal);
        }
    }
}
