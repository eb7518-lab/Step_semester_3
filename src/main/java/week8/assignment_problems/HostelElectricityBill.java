package week8.assignment_problems;

import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    private double units;

    public SingleRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return 8 * units;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    private double units;
    private double occupants;

    public SharedRoom(double units, double occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (6 * units) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACRoom implements Room {
    private double units;

    public ACRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return 10 * units + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                double occupants = sc.nextDouble();
                room = new SharedRoom(units, occupants);
            } else {
                room = new ACRoom(units);
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}