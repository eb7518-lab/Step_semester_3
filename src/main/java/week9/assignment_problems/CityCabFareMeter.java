package week9.assignment_problems;

import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(km * getRate(), MINIMUM_FARE);
    }
}

interface NightService {
    double addNightCharge(double fare);
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (cabType) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(cabType + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).addNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", cabType, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}