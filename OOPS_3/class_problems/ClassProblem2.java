import java.util.*;
import java.time.*;

abstract class LibraryItem {
    protected String title;
    public LibraryItem(String title){ this.title = title; }
    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    public Book(String title){ super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate){ return currentDate.plusDays(14); }
}

class DVD extends LibraryItem {
    public DVD(String title){ super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate){ return currentDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    public Magazine(String title){ super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate){ return currentDate.plusDays(3); }
}

public class ClassProblem2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.of(2023,10,26);
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ",2);
            String type = parts[0];
            String title = parts[1].replace("\"","");
            LibraryItem item = switch(type){
                case "BOOK" -> new Book(title);
                case "DVD" -> new DVD(title);
                case "MAGAZINE" -> new Magazine(title);
                default -> null;
            };
            LocalDate due = item.calculateDueDate(currentDate);
            System.out.println(title + ": " + due);
        }
    }
}
