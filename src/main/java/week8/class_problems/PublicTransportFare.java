package week8.class_problems;

import java.util.Scanner;

interface Transport {
    double calculateFare();
    String getType();
}

class Bus implements Transport {
    private double distance;

    public Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return Math.min(2 + 0.10 * distance, 10);
    }

    public String getType() {
        return "BUS";
    }
}

class Train implements Transport {
    private double distance;

    public Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + 0.15 * distance;
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro implements Transport {
    private double distance;
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Transport transport;

            if (type.equals("BUS")) {
                double distance = sc.nextDouble();
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                double distance = sc.nextDouble();
                transport = new Train(distance);
            } else {
                double distance = sc.nextDouble();
                double peakHourFactor = sc.nextDouble();
                transport = new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", transport.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}