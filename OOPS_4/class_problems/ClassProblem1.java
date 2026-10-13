import java.util.*;

abstract class Plot {
    String owner;
    String shape;
    Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }
    abstract double getArea();
}

class CirclePlot extends Plot {
    double radius;
    CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }
    double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }
    double getArea() {
        return 0.5 * base * height;
    }
}

public class ClassProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for(int i=0;i<n;i++){
            String type = sc.next();
            String owner = sc.next();
            switch(type){
                case "CIRCLE": plots.add(new CirclePlot(owner, sc.nextDouble())); break;
                case "RECTANGLE": plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble())); break;
                case "TRIANGLE": plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble())); break;
            }
        }
        double total=0;
        for(Plot p:plots){
            double area = p.getArea();
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape, area);
            total+=area;
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
