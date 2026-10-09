package week9.class_problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return (100 * 5) + ((units - 100) * 7);
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 8) + 100;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            ElectricityConnection connection;

            if (type.equals("HOME")) {
                connection = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connection = new ShopConnection(units);
            } else {
                connection = new FactoryConnection(units);
            }

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}