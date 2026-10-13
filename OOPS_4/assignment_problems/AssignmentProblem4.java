import java.util.*;

abstract class Cab {
    int km;
    String time;
    Cab(int km,String time){ this.km=km; this.time=time; }
    abstract double rate();
    boolean nightService(){ return false; }
    Double fare(){
        if(time.equals("NIGHT") && !nightService()) return null;
        double f=Math.max(km*rate(),100);
        if(time.equals("NIGHT")) f*=1.2;
        return f;
    }
}

class Mini extends Cab {
    Mini(int km,String time){ super(km,time); }
    double rate(){ return 10; }
}

class Sedan extends Cab {
    Sedan(int km,String time){ super(km,time); }
    double rate(){ return 14; }
    boolean nightService(){ return true; }
}

class SUV extends Cab {
    SUV(int km,String time){ super(km,time); }
    double rate(){ return 18; }
    boolean nightService(){ return true; }
}

public class AssignmentProblem4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Cab> list=new ArrayList<>();
        List<String> types=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            int km=sc.nextInt();
            String time=sc.next();
            switch(type){
                case "MINI": list.add(new Mini(km,time)); break;
                case "SEDAN": list.add(new Sedan(km,time)); break;
                case "SUV": list.add(new SUV(km,time)); break;
            }
            types.add(type);
        }
        double total=0;
        for(int i=0;i<n;i++){
            Cab c=list.get(i);
            Double f=c.fare();
            if(f==null) System.out.printf("%s: night service not available%n", types.get(i));
            else {
                System.out.printf("%s: %.2f%n", types.get(i), f);
                total+=f;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
