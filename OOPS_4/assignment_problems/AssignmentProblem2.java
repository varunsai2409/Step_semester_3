import java.util.*;

abstract class Parcel {
    double weight, value;
    Parcel(double weight,double value){ this.weight=weight; this.value=value; }
    abstract double charge();
    double insurance(){ return 0; } // default
    double total(){ return charge()+insurance(); }
}

class StandardParcel extends Parcel {
    StandardParcel(double w,double v){ super(w,v); }
    double charge(){ return 40 + 10*weight; }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double w,double v){ super(w,v); }
    double charge(){ return 80 + 15*weight; }
    double insurance(){ return 0.02*value; }
}

class FragileParcel extends Parcel {
    FragileParcel(double w,double v){ super(w,v); }
    double charge(){ return 40 + 10*weight + 50; }
    double insurance(){ return 0.02*value; }
}

public class Assignmentproblem2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Parcel> list=new ArrayList<>();
        List<String> types=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            double w=sc.nextDouble(), v=sc.nextDouble();
            switch(type){
                case "STANDARD": list.add(new StandardParcel(w,v)); break;
                case "EXPRESS": list.add(new ExpressParcel(w,v)); break;
                case "FRAGILE": list.add(new FragileParcel(w,v)); break;
            }
            types.add(type);
        }
        double grand=0;
        for(int i=0;i<n;i++){
            Parcel p=list.get(i);
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types.get(i), p.charge(), p.insurance(), p.total());
            grand+=p.total();
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
