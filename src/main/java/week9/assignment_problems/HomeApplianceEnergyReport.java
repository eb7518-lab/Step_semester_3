package week9.assignment_problems;

import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    static final double RATE = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * RATE;
    }
}

interface SaverMode {
    double reduceUnits(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            String type = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2
                    && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).reduceUnits(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}