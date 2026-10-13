import java.util.*;

abstract class Staff {
    String name;
    Staff(String name){ this.name=name; }
    abstract double getPay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;
    FullTimeStaff(String name,double weeklySalary){ super(name); this.weeklySalary=weeklySalary; }
    double getPay(){ return weeklySalary; }
}

class HourlyStaff extends Staff {
    double hours, rate;
    HourlyStaff(String name,double hours,double rate){ super(name); this.hours=hours; this.rate=rate; }
    double getPay(){
        if(hours<=40) return hours*rate;
        else return 40*rate + (hours-40)*rate*1.5;
    }
}

class Intern extends Staff {
    double stipend;
    Intern(String name,double stipend){ super(name); this.stipend=stipend; }
    double getPay(){ return stipend; }
}

public class ClassProblem2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Staff> staffList=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            switch(type){
                case "FULLTIME": staffList.add(new FullTimeStaff(name, sc.nextDouble())); break;
                case "HOURLY": staffList.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble())); break;
                case "INTERN": staffList.add(new Intern(name, sc.nextDouble())); break;
            }
        }
        double total=0;
        for(Staff s:staffList){
            double pay=s.getPay();
            System.out.printf("%s: %.2f%n", s.name, pay);
            total+=pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
