import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;
    LibraryItem(String title,int daysLate){ this.title=title; this.daysLate=daysLate; }
    abstract double getFine();
}

class Book extends LibraryItem {
    Book(String title,int daysLate){ super(title,daysLate); }
    double getFine(){ return daysLate*2; }
}

class DVD extends LibraryItem {
    DVD(String title,int daysLate){ super(title,daysLate); }
    double getFine(){ return Math.min(daysLate*5,50); }
}

class Magazine extends LibraryItem {
    Magazine(String title,int daysLate){ super(title,daysLate); }
    double getFine(){ return daysLate*1; }
}

public class ClassProblem3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<LibraryItem> items=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String title=sc.next();
            int days=sc.nextInt();
            switch(type){
                case "BOOK": items.add(new Book(title,days)); break;
                case "DVD": items.add(new DVD(title,days)); break;
                case "MAGAZINE": items.add(new Magazine(title,days)); break;
            }
        }
        double total=0;
        for(LibraryItem item:items){
            double fine=item.getFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total+=fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
