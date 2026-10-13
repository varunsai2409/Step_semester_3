import java.util.*;

abstract class Student {
    String name;
    Student(String name){ this.name=name; }
    abstract double tuition();
    boolean usesBus(){ return false; }
    double totalFee(){
        double fee=tuition();
        if(usesBus()) fee+=12000;
        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name){ super(name); }
    double tuition(){ return 40000; }
    boolean usesBus(){ return true; }
}

class Hosteller extends Student {
    Hosteller(String name){ super(name); }
    double tuition(){ return 40000+60000; }
}

class Scholar extends Student {
    Scholar(String name){ super(name); }
    double tuition(){ return 20000; }
    boolean usesBus(){ return true; }
}

public class AssignmentProblem3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Student> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            switch(type){
                case "DAY_SCHOLAR": list.add(new DayScholar(name)); break;
                case "HOSTELLER": list.add(new Hosteller(name)); break;
                case "SCHOLAR": list.add(new Scholar(name)); break;
            }
        }
        double total=0;
        for(Student s:list){
            double fee=s.totalFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total+=fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
