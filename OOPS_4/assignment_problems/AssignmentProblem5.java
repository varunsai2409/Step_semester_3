import java.util.*;

abstract class Appliance {
    protected String name;
    protected double power; // in watts

    Appliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public abstract void calculate(double hours, boolean saver);
}

class Fridge extends Appliance {
    Fridge() { super("FRIDGE", 150); }

    @Override
    public void calculate(double hours, boolean saver) {
        if (saver) {
            System.out.println(name + ": saver mode not supported");
            return;
        }
        double units = (power * hours) / 1000.0;
        double cost = units * 8;
        System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        HomeApplianceEnergyReport.totalCost += cost;
    }
}

class AC extends Appliance {
    AC() { super("AC", 1500); }

    @Override
    public void calculate(double hours, boolean saver) {
        double units = (power * hours) / 1000.0;
        if (saver) units *= 0.75; // reduce by 25%
        double cost = units * 8;
        System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        HomeApplianceEnergyReport.totalCost += cost;
    }
}

class TV extends Appliance {
    TV() { super("TV", 100); }

    @Override
    public void calculate(double hours, boolean saver) {
        if (saver) {
            System.out.println(name + ": saver mode not supported");
            return;
        }
        double units = (power * hours) / 1000.0;
        double cost = units * 8;
        System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        HomeApplianceEnergyReport.totalCost += cost;
    }
}

class Washer extends Appliance {
    Washer() { super("WASHER", 500); }

    @Override
    public void calculate(double hours, boolean saver) {
        double units = (power * hours) / 1000.0;
        if (saver) units *= 0.75;
        double cost = units * 8;
        System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        HomeApplianceEnergyReport.totalCost += cost;
    }
}

public class HomeApplianceEnergyReport {
    static double totalCost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length == 3 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance = null;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(); break;
                case "AC": appliance = new AC(); break;
                case "TV": appliance = new TV(); break;
                case "WASHER": appliance = new Washer(); break;
            }

            if (appliance != null) {
                appliance.calculate(hours, saver);
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
