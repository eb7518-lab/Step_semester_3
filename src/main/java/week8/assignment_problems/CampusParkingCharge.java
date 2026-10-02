package week8.assignment_problems;

import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
    String getType();
}

class Bike implements Vehicle {
    private double hours;

    public Bike(double hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 10 * hours;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car implements Vehicle {
    private double hours;

    public Car(double hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }

    public String getType() {
        return "CAR";
    }
}

class Truck implements Vehicle {
    private double hours;

    public Truck(double hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return Math.max(50 * hours, 100);
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicle = new Car(hours);
            } else {
                vehicle = new Truck(hours);
            }

            double charge = vehicle.calculateCharge();
            total += charge;

            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}